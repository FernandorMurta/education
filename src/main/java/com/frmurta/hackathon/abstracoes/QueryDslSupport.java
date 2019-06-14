package com.frmurta.hackathon.abstracoes;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collections;
import java.util.List;

public abstract class QueryDslSupport extends QuerydslRepositorySupport {

    public QueryDslSupport(Class<?> domainClass) {
        super(domainClass);
    }

    protected Page readPage(JPAQuery query, Pageable pageable) {
        if (pageable == null) {
            return readPage(query, new QPageRequest(0, Integer.MAX_VALUE));
        }
        long      total      = query.clone(super.getEntityManager()).fetchCount();
        JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
        List      content    = total > pageable.getOffset() ? pagedQuery.fetch() : Collections.emptyList();
        return new PageImpl<>(content, pageable, total);
    }
}
