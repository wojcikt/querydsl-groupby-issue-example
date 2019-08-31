package com.example.demo;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.querydsl.QBar.bar;
import static com.example.demo.querydsl.QFoo.foo;

@Component
public class FooDao {

    private final SQLQueryFactory queryFactory;

    private final Expression<Bar> barExpr = Projections.constructor(
            Bar.class,
            bar.id
    );

    private final Expression<Foo> fooExpr = Projections.constructor(
            Foo.class,
            foo.id,
            foo.name,
            GroupBy.set(barExpr)
    );

    public FooDao(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Transactional(readOnly = true)
    public List<Foo> getFoosUsingExpression() {
        return queryFactory
                .from(foo)
                .leftJoin(foo._barFooFk, bar)
                .orderBy(foo.id.asc())
                .transform(GroupBy.groupBy(foo.id).list(fooExpr));
    }

    @Transactional(readOnly = true)
    public List<Foo> getFoosUsingConstructorExpression() {
        return queryFactory
                .from(foo)
                .leftJoin(foo._barFooFk, bar)
                .orderBy(foo.id.asc())
                .transform(GroupBy.groupBy(foo.id).list((FactoryExpression<Foo>) fooExpr));
    }

}
