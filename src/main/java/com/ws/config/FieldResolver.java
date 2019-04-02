package com.ws.config;

import java.util.Locale;


/**
 * Created by gl on 2019/4/1.
 */
public interface FieldResolver {
    /**
     *
     * @param fieldName
     * @return 英文字段名对应的中文描述名
     */
    String resolve(String fieldName, Locale locale);
}
