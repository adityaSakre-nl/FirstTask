package com.spring.firsttask.controller;

import com.spring.firsttask.entity.Courses;
import com.spring.firsttask.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("getAll")
    public List<Courses> getAllCourses()
    {
        return coursesService.getAllCourses();
    }

    @GetMapping("getById/{id}")
    public Courses getById(@PathVariable int id)
    {
        return coursesService.getCourseByID(id);
    }

    @PostMapping("add")
    public Courses insertCourse(@RequestBody Courses course)
    {
        return coursesService.insertCourse(course);
    }


    @PostMapping("update")
    public Courses updateCourese(@RequestBody Courses course)
    {
        return coursesService.updateCourse(course);
    }

    @GetMapping("delAll")
    public String deleteAllCourses()
    {
        coursesService.deleteAll();
        return "All Courses deleted";
    }

    @GetMapping("del/{id}")
    public String deleteCourse(@PathVariable int id){
        try{
            coursesService.deleteCourseByID(id);
            return "Course with id:"+id+" removed";

        }
        catch (Exception e)
        {
            return "Course with id:"+id+"not found";
        }
    }

    @GetMapping("cnt")
    public String countCourses()
    {
        return "Total no. of courses: "+coursesService.coursesCount();
    }

    @GetMapping("is/{id}")
    public String doesExistbyId(@PathVariable int id)
    {
        var out = coursesService.existCourseById(id);
        if (out)
        {
            return  "Course with id: "+id +" exists";
        }
        else
            return  "No Course  with id: "+id +" found";
    }
}
