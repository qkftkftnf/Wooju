package com.wooju.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDaily is a Querydsl query type for Daily
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDaily extends EntityPathBase<Daily> {

    private static final long serialVersionUID = 1828806663L;

    public static final QDaily daily = new QDaily("daily");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath keyword = createString("keyword");

    public QDaily(String variable) {
        super(Daily.class, forVariable(variable));
    }

    public QDaily(Path<? extends Daily> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDaily(PathMetadata metadata) {
        super(Daily.class, metadata);
    }

}

