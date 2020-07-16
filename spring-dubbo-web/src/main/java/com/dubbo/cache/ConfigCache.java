package com.dubbo.cache;

import com.alibaba.dubbo.cache.Cache;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>className: ConfigCache</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-09 14:43
 */
public class ConfigCache implements Cache {

    Map<Object,Object> map = new ConcurrentHashMap<>();
    private final Map<Object, Object> store;

    public ConfigCache(URL url) {
        final int max = url.getParameter("cache.size", 1000);   //定义了缓存的容量
        this.store = new LinkedHashMap<Object, Object>() {
            private static final long serialVersionUID = -3834209229668463829L;
            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) { //jdk提供的接口，用于移除最旧条目的需求
                return size() > max;
            }
        };
    }
    @Override
    public void put(Object key, Object value) {
        synchronized (store) {  //注意这里的同步条件
            store.put(key, value);
        }
    }
    @Override
    public Object get(Object key) {
        synchronized (store) {  //注意这里的同步条件
            return store.get(key);
        }
    }
}