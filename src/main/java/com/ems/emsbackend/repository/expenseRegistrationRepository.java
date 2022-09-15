package com.ems.emsbackend.repository;

import com.ems.emsbackend.model.expenseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface expenseRegistrationRepository extends JpaRepository<expenseRegistration,Long> {
}
