package com.example.onetoone;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{


	
}
