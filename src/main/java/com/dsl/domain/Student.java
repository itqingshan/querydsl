package com.dsl.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student extends BaseModel{

    private String name;

    private Long age;

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Teacher teacher;
}
