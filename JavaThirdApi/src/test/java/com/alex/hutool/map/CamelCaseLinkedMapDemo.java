package com.alex.hutool.map;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.core.map.CamelCaseLinkedMap;
import cn.hutool.core.util.RuntimeUtil;
import org.junit.Test;

public class CamelCaseLinkedMapDemo {
    @Test
    public void test01 (){
        CamelCaseLinkedMap camelCaseLinkedMap = new CamelCaseLinkedMap();
        camelCaseLinkedMap.put("wjj_dasa","45");
        camelCaseLinkedMap.put("int_value","45");

        final Object wjj_dasa = camelCaseLinkedMap.get("wjj_dasa");
        final Object wjjDasa = camelCaseLinkedMap.get("wjjDasa");
        System.out.println(wjj_dasa+"------"+wjjDasa+"--------------"+wjj_dasa.equals(wjjDasa));
    }


    @Test
    public void testCacheUtil (){
        final FIFOCache<Object, Object> cache = CacheUtil.newFIFOCache(45, 45);
        cache.put("das","Alex");
        System.out.println(cache.get("das"));

        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println(str);
    }
}
