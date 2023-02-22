package com.dsl.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher extends BaseModel{

    private String name;

    private Long age;

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private School school;

}
