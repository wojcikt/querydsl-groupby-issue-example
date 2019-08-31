package com.example.demo.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QFoo is a Querydsl query type for QFoo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QFoo extends com.querydsl.sql.RelationalPathBase<QFoo> {

    private static final long serialVersionUID = -162110508;

    public static final QFoo foo = new QFoo("FOO");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<QFoo> constraint1 = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<QBar> _barFooFk = createInvForeignKey(id, "FOO_ID");

    public QFoo(String variable) {
        super(QFoo.class, forVariable(variable), "PUBLIC", "FOO");
        addMetadata();
    }

    public QFoo(String variable, String schema, String table) {
        super(QFoo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QFoo(String variable, String schema) {
        super(QFoo.class, forVariable(variable), schema, "FOO");
        addMetadata();
    }

    public QFoo(Path<? extends QFoo> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "FOO");
        addMetadata();
    }

    public QFoo(PathMetadata metadata) {
        super(QFoo.class, metadata, "PUBLIC", "FOO");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
    }

}

