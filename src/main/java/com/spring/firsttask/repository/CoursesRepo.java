package com.spring.firsttask.repository;

import com.spring.firsttask.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses,Integer> {
}
