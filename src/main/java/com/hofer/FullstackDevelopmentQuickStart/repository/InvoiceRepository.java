package com.hofer.FullstackDevelopmentQuickStart.repository;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
