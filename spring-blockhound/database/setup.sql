--------------------------------------------------------
--  Create generate uuid function
--------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

------------------------------------------------------------------
-- Create participant table
------------------------------------------------------------------
DO
$$
BEGIN
  IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'participant') THEN
    create table participant (
    participant_id UUID DEFAULT gen_random_uuid(),
    code INTEGER NOT NULL,
    name VARCHAR(200) NOT NULL,
    PRIMARY KEY (participant_id)
    );
    comment on column participant.participant_id is 'Inner guid of participant';
    comment on column participant.code is	'Participant`s code';
    comment on column participant.name is 'Participant`s name';
    RAISE INFO 'Added participant table';
  ELSE
    RAISE INFO 'participant table already added';
  END IF;
END
$$;