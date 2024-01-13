package com.laborator.FootballDatabase.Repository;
import com.laborator.FootballDatabase.Domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface ManagerRepository extends JpaRepository<Manager, Long> {
}