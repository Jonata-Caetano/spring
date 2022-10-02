package com.bmarques.springmongo.invoice

import org.springframework.data.mongodb.repository.MongoRepository

interface InvoiceRepository: MongoRepository<Invoice, Int>