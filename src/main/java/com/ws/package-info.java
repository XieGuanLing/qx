/**
 * create by gl
 * on 2019/3/27
 *
 * 定义过滤器
 * 便于在Where注解中使用
 */

@FilterDef(name = DataFilterConstants.NOT_SOFT_DELETE_FILTER_NAME, defaultCondition = DataFilterConstants.NOT_SOFT_DELETE_CONDITION)
package com.ws;


import com.ws.misc.DataFilterConstants;
import org.hibernate.annotations.FilterDef;