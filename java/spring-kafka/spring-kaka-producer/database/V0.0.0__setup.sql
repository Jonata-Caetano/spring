--------------------------------------------------------
--  Create generate uuid function
--------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
------------------------------------------------------------------
-- Create merchant table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'merchant') THEN
      create table merchant (
        merchant_id UUID DEFAULT gen_random_uuid(),
        name VARCHAR(200) NOT NULL,
        slug VARCHAR(50) NOT NULL,
        delivery BOOLEAN NOT NULL,
        whats_app_phone VARCHAR(50) NOT NULL,
        PRIMARY KEY (merchant_id)
      );
      comment on column merchant.merchant_id is 'Inner guid of merchant';
      comment on column merchant.name is 'Merchant`s name';
      comment on column merchant.slug is 'Merchant`s slug';
      comment on column merchant.delivery is 'Flag to delivery is actived';
      comment on column merchant.whats_app_phone is 'Merchant`s whats app phone';
      RAISE INFO 'Added merchant table';
    ELSE
      RAISE INFO 'merchant table already added';
    END IF;
  END
$$;