package com.ems.emsbackend.repository;


import com.ems.emsbackend.model.expenseList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface expenseListRepository extends JpaRepository<expenseList, Long> {
}
