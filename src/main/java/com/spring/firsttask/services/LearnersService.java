package com.spring.firsttask.services;

import com.spring.firsttask.entity.Learners;
import com.spring.firsttask.repository.LearnersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnersService {

    @Autowired
    LearnersRepo learnersRepo;

    //Get all Learners
    public List<Learners> getAllLearners()
    {
        return learnersRepo.findAll();
    }

    //Get Learner by ID
    public Learners getLearnerByID(int id)
    {
        return learnersRepo.findById(id).get();
    }

    //Insert Learner
    public Learners insertLearner(Learners learner)
    {
       return learnersRepo.save(learner);
    }


    //Delete Learner by ID
    public void deleteLearnerByID(int id)
    {
        Optional<Learners> probUser = learnersRepo.findById(id);
        if (probUser.isEmpty())
        {
            throw  new RuntimeException("Learner with id: "+id +" doesn't exist");
        }
        learnersRepo.deleteById(id);
    }


    //Delete All Learners
    public void deleteAll(){
        learnersRepo.deleteAll();
    }


    //Update Learner
    public Learners updateLearner(Learners learner)
    {
        var temp =  learnersRepo.findById(learner.getLearner_id());
        if (temp.isEmpty())
        {
            throw  new RuntimeException("Learner with given details doesn't exist");
        }

        //Learner by Id found////////////////////////////////////////////////////////////
        var learnerToUpdate = temp.get();

       //Updating the learners entry
        if (learner.getLearner_first_name() != null && learner.getLearner_first_name() != "")
        {
            learnerToUpdate.setLearner_first_name(learner.getLearner_first_name());
        }

        if (learner.getLearner_last_name() != null && learner.getLearner_last_name() != "")
        {
            learnerToUpdate.setLearner_last_name(learner.getLearner_last_name());
        }

        if (learner.getLearner_email() != null && learner.getLearner_email() != "")
        {
            learnerToUpdate.setLearner_email(learner.getLearner_email());
        }

        if (learner.getLearner_password() != null && learner.getLearner_password() != "")
        {
            learnerToUpdate.setLearner_password(learner.getLearner_password());
        }


        if (learner.getCourse_id() != 0)
        {
            learnerToUpdate.setCourse_id(learner.getCourse_id());
        }
        ////////////////////////////////////////////////////////////////////////////////

        return learnersRepo.save(learnerToUpdate);
    }


    //Get count of Learners
    public  int learnersCount(){
        return learnersRepo.findAll().size();
    }


    //If exist
    public boolean existLearnerByID(int id)
    {
        Optional<Learners> probUser = learnersRepo.findById(id);
        return probUser.isPresent();
    }
}
