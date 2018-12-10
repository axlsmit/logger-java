package com.pe.cema.factorylogger.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="LOG_ENTITY")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String className;

    private String methodName;

    private String level;
}
