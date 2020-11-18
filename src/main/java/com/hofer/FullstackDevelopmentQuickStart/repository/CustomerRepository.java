package com.hofer.FullstackDevelopmentQuickStart.repository;

import com.hofer.FullstackDevelopmentQuickStart.model.response.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
