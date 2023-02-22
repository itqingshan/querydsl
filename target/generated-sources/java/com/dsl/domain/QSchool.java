package com.dsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchool is a Querydsl query type for School
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchool extends EntityPathBase<School> {

    private static final long serialVersionUID = -2059236768L;

    public static final QSchool school = new QSchool("school");

    public final QBaseModel _super = new QBaseModel(this);

    public final StringPath address = createString("address");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<Teacher, QTeacher> teachers = this.<Teacher, QTeacher>createList("teachers", Teacher.class, QTeacher.class, PathInits.DIRECT2);

    public QSchool(String variable) {
        super(School.class, forVariable(variable));
    }

    public QSchool(Path<? extends School> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchool(PathMetadata metadata) {
        super(School.class, metadata);
    }

}

