package com.spring.firsttask.controller;

import com.spring.firsttask.entity.Learners;
import com.spring.firsttask.services.LearnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learner")
public class LearnersController {

    @Autowired
    LearnersService learnersService;

    @GetMapping("getAll")
    public List<Learners> getAllLearners()
    {
        return learnersService.getAllLearners();
    }

    @GetMapping("getById/{id}")
    public Learners getById(@PathVariable int id)
    {
        return learnersService.getLearnerByID(id);
    }


    @PostMapping("add")
    public Learners insertLearner(@RequestBody Learners learner)
    {
        return learnersService.insertLearner(learner);
    }


    @GetMapping("del/{id}")
    public String deleteById(@PathVariable int id)
    {
        try{
            learnersService.deleteLearnerByID(id);
            return "Learner with id:"+id+" removed";

        }
        catch (Exception e)
        {
            return "Learner with id:"+id+"not found";
        }
    }

    @GetMapping("delAll")
    public String deleteAll()
    {
        learnersService.deleteAll();
        return "All Learners records removed";
    }


    @PostMapping("update")
    public Learners updateLearner(@RequestBody Learners learner)
    {
        return learnersService.updateLearner(learner);
    }


    @GetMapping("cnt")
    public String learnersCount()
    {
        return "Total no. of learners: "+learnersService.learnersCount();
    }


    @GetMapping("is/{id}")
    public String doesExistbyId(@PathVariable int id)
    {
        var out = learnersService.existLearnerByID(id);
        if (out)
        {
            return  "Learner with id: "+id +" exists";
        }
        else
            return  "No Learner  with id: "+id +" found";
    }
}
