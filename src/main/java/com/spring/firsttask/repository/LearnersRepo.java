package com.spring.firsttask.repository;

import com.spring.firsttask.entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnersRepo extends JpaRepository<Learners,Integer> {
}
