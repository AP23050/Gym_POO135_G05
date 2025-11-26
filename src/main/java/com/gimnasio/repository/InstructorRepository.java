package com.gimnasio.repository;

import com.gimnasio.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Spring Data JPA te regala los métodos save(), findAll(), findById(), etc.
}
