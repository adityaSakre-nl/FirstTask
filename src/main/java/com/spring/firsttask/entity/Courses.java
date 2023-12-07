package com.spring.firsttask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Courses{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_Id;
    private String course_name;
    private String course_description;
}
