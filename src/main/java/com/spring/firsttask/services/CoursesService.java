package com.spring.firsttask.services;

import com.spring.firsttask.entity.Courses;
import com.spring.firsttask.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepo coursesRepo;

    //Get all Courses
    public List<Courses> getAllCourses()
    {
        return coursesRepo.findAll();
    }

    //Get Course by ID
    public Courses getCourseByID(int id)
    {
        return coursesRepo.findById(id).get();
    }

    //Insert Courses
    public Courses insertCourse(Courses course)
    {
       return coursesRepo.save(course);
    }


    //Delete Course by ID
    public void deleteCourseByID(int id)
    {
        Optional<Courses> probUser = coursesRepo.findById(id);
        if (probUser.isEmpty())
        {
            throw  new RuntimeException("Learner with id: "+id +" doesn't exist");
        }
        coursesRepo.deleteById(id);
    }


    //Delete All Courses
    public void deleteAll(){
        coursesRepo.deleteAll();
    }


    //Update Course
    public Courses updateCourse(Courses course)
    {
        var temp =  coursesRepo.findById(course.getCourse_Id());
        if (temp.isEmpty())
        {
            throw  new RuntimeException("Course with given details doesn't exist");
        }

        //Learner by Id found////////////////////////////////////////////////////////////
        var courseToUpdate = temp.get();

       //Updating the learners entry
        if (course.getCourse_name() != null && course.getCourse_name() != "" )
        {
            courseToUpdate.setCourse_name(course.getCourse_name());
        }

        if (course.getCourse_description() != null && course.getCourse_description() != "")
        {
            courseToUpdate.setCourse_description(course.getCourse_description());
        }

        ////////////////////////////////////////////////////////////////////////////////

        return coursesRepo.save(courseToUpdate);
    }

    //Get count of Courses
    public  int coursesCount(){
        return coursesRepo.findAll().size();
    }


    //If course exists
    public boolean existCourseById(int id)
    {
        var temp =  coursesRepo.findById(id);
        return temp.isPresent();
    }
}
