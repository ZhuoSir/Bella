package com.creheart.util;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * Created by sunny on 2017/6/4.
 */
public class CacheUtils {

    /**
     * 根据EhCache.xml配置生成CacheManager
     *
     * */
    public static CacheManager getXmlConfigCacheManager() {
        final URL url = CacheUtils.class.getClass().getResource("/EhCache.xml");
        XmlConfiguration xmlConfiguration = new XmlConfiguration(url);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfiguration);
        cacheManager.init();
        return cacheManager;
    }
}
