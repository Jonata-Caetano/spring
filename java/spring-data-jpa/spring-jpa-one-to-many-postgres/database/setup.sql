--------------------------------------------------------
--  Create generate uuid function
--------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

------------------------------------------------------------------
-- Create client table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'invoice') THEN
      create table invoice (
        invoice_id UUID DEFAULT gen_random_uuid(),
        document INTEGER NOT NULL,
        value numeric(13,2) NOT NULL,
        PRIMARY KEY (invoice_id)
      );

      create table invoice_item (
        invoice_item_id UUID DEFAULT gen_random_uuid(),
        invoice_id UUID,
        product_code INTEGER NOT NULL,
        item_value numeric(13,2) NOT NULL,
        PRIMARY KEY (invoice_item_id),
        CONSTRAINT fk_invoice_item_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(invoice_id)
            );
      RAISE INFO 'Added invoice table';
    ELSE
      RAISE INFO 'invoice table already added';
    END IF;
  END
$$;