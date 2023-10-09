package com.example.springbatch.repo;

import com.example.springbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CutomerRepository extends JpaRepository<Customer, Integer> {
}
