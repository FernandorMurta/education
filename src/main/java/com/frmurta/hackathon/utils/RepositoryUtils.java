package com.frmurta.hackathon.utils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;

public class RepositoryUtils {

    public static String ignoreAccentsTemplate = "lower(translate({0}, 'âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç', 'aaaaaaaaeeeeiioooooouuuucc'))";

    public static BooleanExpression getStringContainsIgnoreCaseAndAccents(StringPath path, String stringToVerify) {
        return Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, path)
                .contains(Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, stringToVerify));
    }

    public static BooleanExpression getStringStartWithIgnoreCaseAndAccents(StringPath path, String stringToVerify) {
        return Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, path)
                .startsWith(Expressions.stringTemplate(RepositoryUtils.ignoreAccentsTemplate, stringToVerify));
    }

}
