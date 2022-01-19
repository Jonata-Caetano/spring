create table invoice (
    invoice_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    document INTEGER NOT NULL,
    value numeric(13,2) NOT NULL,
    PRIMARY KEY (invoice_id)
);

create table invoice_item (
    invoice_item_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    invoice_id NUMBER NULL,
    product_code INTEGER NOT NULL,
    item_value numeric(13,2) NOT NULL,
    PRIMARY KEY (invoice_item_id),
    CONSTRAINT fk_invoice_item_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(invoice_id)
);
