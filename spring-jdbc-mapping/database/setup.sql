--------------------------------------------------------
--  Add table standard
--------------------------------------------------------
DO $$
BEGIN
IF NOT EXISTS (SELECT 1 FROM pg_tables WHERE tablename = 'standard') THEN
   -- create the table
   CREATE TABLE standard
   (
      -- standard tracking fields.
      deleted bool NOT NULL DEFAULT false,
      create_date timestamp(6) without time zone NOT NULL DEFAULT now(),
      delete_date timestamp(6) without time zone,
      changed timestamp(6) without time zone,
      created_by__contact_id uuid NOT NULL,
      deleted_by__contact_id uuid,
      changed_by__contact_id uuid,

      -- add constraints.
      constraint standard_chk1
      check((deleted=true  and delete_date is not null and deleted_by__contact_id is not null)
      or (deleted=false and delete_date is     null and deleted_by__contact_id is null)),

      constraint standard_chk2
      check((changed is not null and changed_by__contact_id is not null)
      or (changed is     null and changed_by__contact_id is null))
   );

      -- add comments
      COMMENT ON COLUMN standard.deleted IS 'Whether we''ve been deleted or not.';
      COMMENT ON COLUMN standard.create_date IS 'The date/time this record was created.';
      COMMENT ON COLUMN standard.delete_date IS 'The date/time this record was deleted.';
      COMMENT ON COLUMN standard.changed IS 'The date/time this record was last modified.';
      COMMENT ON COLUMN standard.created_by__contact_id IS 'The contact guid this record was created by.';
      COMMENT ON COLUMN standard.deleted_by__contact_id IS 'The contact guid this record was deleted by.';
      COMMENT ON COLUMN standard.changed_by__contact_id IS 'The contact guid this record was modified by.';

      RAISE INFO 'Added standard table';
   ELSE
      RAISE INFO 'Standard table already added';
   END IF;
END
$$;
--------------------------------------------------------
--  Add table participant
--------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'participant') THEN
      CREATE TABLE participant
      (
        participant_id      UUID         PRIMARY KEY,
        company_id          UUID         NOT NULL,
        name                VARCHAR(256) NOT NULL,
        registration_code   NUMERIC NOT NULL,
        registration_type   VARCHAR(256) NOT NULL,
        registration_number VARCHAR(256) NOT NULL
      ) inherits (standard);

      RAISE INFO 'Added participant table';
    ELSE
      RAISE INFO 'participant table already added';
    END IF;
  END
$$;
--------------------------------------------------------
--  Add table participant_period_effect
--------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'participant_period_effect') THEN
      CREATE TABLE participant_period_effect
      (
        participant_period_effect_id UUID PRIMARY KEY,
        company_id               UUID         NOT NULL,
        participant_id           UUID         NOT NULL,
        start_date               TIMESTAMP    NOT NULL,
        name                     VARCHAR(256) NOT NULL,
        legal_name               VARCHAR(256),
        counting_basis           VARCHAR(256),
        company_size             VARCHAR(256),
        legal_nature             VARCHAR(256),
        main_cnae                VARCHAR(256),
        state_inscription        VARCHAR(256),
        municipal_inscription    VARCHAR(256),
        suframa_inscription      VARCHAR(256),
        CONSTRAINT participant_id_fk FOREIGN KEY (participant_id)
        REFERENCES participant (participant_id)
      ) inherits (standard);

      RAISE INFO 'Added participant_period_effect table';
    ELSE
      RAISE INFO 'participant_period_effect table already added';
    END IF;
  END
$$
--------------------------------------------------------
--  Add table contact_period_effect_address
--------------------------------------------------------
--DO
--$$
--BEGIN
--IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'contact_period_effect_address') THEN
--CREATE TABLE contact_period_effect_address
--(
--contact_period_effect_address_id UUID PRIMARY KEY,
--company_id                       UUID         NOT NULL,
--contact_period_effect_id         UUID         NOT NULL,
--period_effect_start_date         TIMESTAMP    NOT NULL,
--country                          VARCHAR(256) NOT NULL,
--zip_code                         VARCHAR(256),
--address                          VARCHAR(256) NOT NULL,
--number                           NUMERIC(6),
--additional_address               VARCHAR(256),
--state                            VARCHAR(256) NOT NULL,
--city                             VARCHAR(256) NOT NULL,
--neighborhood                     VARCHAR(256),
--address_type                     VARCHAR(256) NOT NULL,
--CONSTRAINT contact_period_effect_id_fk FOREIGN KEY (contact_period_effect_id)
--REFERENCES contact_period_effect (contact_period_effect_id)
--) inherits (standard);
--RAISE INFO 'Added contact_period_effect_address table';
--ELSE
--RAISE INFO 'contact_period_effect_address table already added';
--END IF;
--END
--$$;
--------------------------------------------------------
--  Add table contact_period_effect_phone
--------------------------------------------------------
--DO
--$$
--BEGIN
--IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'contact_period_effect_phone') THEN
--CREATE TABLE contact_period_effect_phone
--(
--contact_phone_id         UUID PRIMARY KEY,
--contact_period_effect_id UUID         NOT NULL,
--company_id               UUID         NOT NULL,
--phone_number             VARCHAR(256) NOT NULL,
--extension_line           VARCHAR(256) NOT NULL,
--type                     VARCHAR(256) NOT NULL,
--CONSTRAINT contact_period_effect_id_fk FOREIGN KEY (contact_period_effect_id)
--REFERENCES contact_period_effect (contact_period_effect_id)
--) inherits (standard);
--RAISE INFO 'Added contact_period_effect_phone table';
--ELSE
--RAISE INFO 'contact_period_effect_phone table already added';
--END IF;
--END
--$$;
--------------------------------------------------------
--  Add table contact_period_effect_email
--------------------------------------------------------
--DO
--$$
--BEGIN
--IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'contact_period_effect_email') THEN
--CREATE TABLE contact_period_effect_email
--(
--contact_email_id         UUID PRIMARY KEY,
--contact_period_effect_id UUID         NOT NULL,
--company_id               UUID         NOT NULL,
--email_address            VARCHAR(256) NOT NULL,
--type                     VARCHAR(256) NOT NULL,
--CONSTRAINT contact_email_id_fk FOREIGN KEY (contact_period_effect_id)
--REFERENCES contact_period_effect (contact_period_effect_id)
--) inherits (standard);
--RAISE INFO 'Added contact_period_effect_email table';
--ELSE
--RAISE INFO 'contact_period_effect_email table already added';
--END IF;
--END
--$$;
