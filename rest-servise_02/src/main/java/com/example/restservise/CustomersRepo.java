package com.example.restservise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepo extends JpaRepository<Customers, Integer> {
}
