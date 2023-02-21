package com.example.firstJWTprojectItAcad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name= "car")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private Date prodDate;
    private Double consume;
    private int maxSpeed;
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User userId;



}
