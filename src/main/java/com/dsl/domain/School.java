package com.dsl.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "school")
@Data
public class School extends BaseModel{

    private String name;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "school")
    private List<Teacher> teachers;
}
