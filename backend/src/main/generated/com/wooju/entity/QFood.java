package com.wooju.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFood is a Querydsl query type for Food
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFood extends EntityPathBase<Food> {

    private static final long serialVersionUID = -1464953680L;

    public static final QFood food = new QFood("food");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath img = createString("img");

    public final StringPath name = createString("name");

    public QFood(String variable) {
        super(Food.class, forVariable(variable));
    }

    public QFood(Path<? extends Food> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood(PathMetadata metadata) {
        super(Food.class, metadata);
    }

}

