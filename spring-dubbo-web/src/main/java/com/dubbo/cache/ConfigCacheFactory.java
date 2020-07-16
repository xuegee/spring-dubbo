package com.dubbo.cache;

import com.alibaba.dubbo.cache.Cache;
import com.alibaba.dubbo.cache.CacheFactory;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;

/**
 * <p>className: ConfigCacheFactory</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-07-10 11:14
 */
public class ConfigCacheFactory implements CacheFactory {


    @Override
    public Cache getCache(URL url, Invocation invocation) {
        return new ConfigCache(url);
    }
}