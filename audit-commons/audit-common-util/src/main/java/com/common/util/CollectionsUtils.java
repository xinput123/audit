package com.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * 集合的基础类
 */
public class CollectionsUtils {
    /** 判断 Collection 集合是否为空 */
    public static boolean isEmptyOrNull(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    /** 判断 Collection 集合是否不为空 */
    public static boolean isNotEmptyOrNull(Collection<?> collection){
        return !isEmptyOrNull(collection);
    }

    /** 判断Map 是否为空 */
    public static boolean isEmptyOrNull(Map<?,?> map){
        return map == null || map.isEmpty();
    }

    /** 判断Map 是否不为空 */
    public static boolean isNotEmptyOrNull(Map<?,?> map){
        return !isEmptyOrNull(map);
    }
}
