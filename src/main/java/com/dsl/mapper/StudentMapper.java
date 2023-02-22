package com.dsl.mapper;

import com.dsl.domain.Student;
import com.dsl.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring")
//@Component
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "teacher.name", target = "teacherName"),
            @Mapping(source = "teacher.school.name", target = "schoolName")
    })
    StudentDTO entity2dto(Student student);

}
