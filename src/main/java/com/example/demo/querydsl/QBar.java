package com.example.demo.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBar is a Querydsl query type for QBar
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBar extends com.querydsl.sql.RelationalPathBase<QBar> {

    private static final long serialVersionUID = -162114783;

    public static final QBar bar = new QBar("BAR");

    public final NumberPath<Long> fooId = createNumber("fooId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.querydsl.sql.PrimaryKey<QBar> constraintF = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<QFoo> barFooFk = createForeignKey(fooId, "ID");

    public QBar(String variable) {
        super(QBar.class, forVariable(variable), "PUBLIC", "BAR");
        addMetadata();
    }

    public QBar(String variable, String schema, String table) {
        super(QBar.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBar(String variable, String schema) {
        super(QBar.class, forVariable(variable), schema, "BAR");
        addMetadata();
    }

    public QBar(Path<? extends QBar> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "BAR");
        addMetadata();
    }

    public QBar(PathMetadata metadata) {
        super(QBar.class, metadata, "PUBLIC", "BAR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(fooId, ColumnMetadata.named("FOO_ID").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

