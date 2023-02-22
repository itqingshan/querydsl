package com.dsl.service;

import com.dsl.domain.QStudent;
import com.dsl.domain.Student;
import com.dsl.service.dto.StudentDTO;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TestService {

    @Autowired
    private EntityManager entityManager;


    /**
     *  先将实体类查出来
     *  然后再转为dto
     * @param name
     * @return
     */
    public StudentDTO findStudents(String name){
        QStudent student = QStudent.student;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Student k = queryFactory.selectFrom(student)
                .where(student.name.eq(name))
                .fetchOne();

        StudentDTO dto = new StudentDTO();

        dto.setName(k.getName());
        dto.setAge(k.getAge());
        dto.setGender(k.getGender());
        dto.setTeacherName(k.getTeacher().getName());
        dto.setSchoolName(k.getTeacher().getSchool().getName());

        return dto;
    }

    /**
     *  直接从数据库查出数据并将数据封装到dto
     * @param name
     * @return
     */
    public StudentDTO findTeachers(String name){
        QStudent student = QStudent.student;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        JPAQuery<Tuple> jpaQuery = new JPAQuery<>(entityManager);
        StudentDTO dto = queryFactory.select(
                        Projections.bean(
                                StudentDTO.class,
                                student.name,
                                student.age,
                                student.gender,
                                student.teacher.name.as("teacherName"),
                                student.teacher.school.name.as("schoolName"))
                )
                .from(student)
                .where(student.name.eq(name))
                .fetchOne();


        return dto;
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(formatter.format(now));
    }

}
