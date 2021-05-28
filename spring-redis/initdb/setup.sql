CREATE TABLE account
(
  account_id INTEGER NOT NULL,
  number INTEGER NOT NULL,
  bank_branch INTEGER NOT NULL,
  CONSTRAINT account_pk PRIMARY KEY (account_id)
);