/**
 * 
 */
package com.servicenow.snredis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicenow.snredis.entities.Student;

/**
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
