package com.chen.JeneralDB.cache;

import java.util.*;

/**
 * Created by sunny on 2017/1/8.
 */
public class CacheManager {

    private static CacheManager cacheManager = null;

    private static HashMap cacheMap = new HashMap();

    private static final long defaultDt = 10000000L;

    private CacheManager() {
    }


    public static synchronized CacheManager getInstance() {
        if (null == cacheManager) {
            cacheManager = new CacheManager();
        }

        return cacheManager;
    }


    public synchronized boolean isExisted(String key) {
        return cacheMap.containsKey(key);
    }


    public synchronized Cache getCache(String key) {
        return (Cache) cacheMap.get(key);
    }


    public synchronized Object getCacheValue(String key) {
        return getCache(key).getValue();
    }


    public synchronized boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }


    public synchronized void clearAll() {
        cacheMap.clear();
    }


    public synchronized void clearAll(String type) {
        Iterator iterator = cacheMap.keySet().iterator();
        String key = null;
        ArrayList<String> arrayList = new ArrayList();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            key = (String) entry.getKey();
            if (key.startsWith(type)) {
                arrayList.add(key);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            clearOnly(arrayList.get(i));
        }
    }


    private synchronized void clearOnly(String key) {
        cacheMap.remove(key);
    }


    public synchronized void putCache(String key, Cache obj) {
        cacheMap.put(key, obj);
    }


    public synchronized Cache getCacheInfo(String key) {
        if (hasCache(key)) {
            Cache cache = getCache(key);
            if (cacheExpired(cache)) {
                cache.setExpired(true);
            }
            return cache;
        } else {
            return null;
        }
    }


    public synchronized void putCacheInfo(String key, Object obj, long dt, boolean expired) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setExpired(expired);
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        cacheMap.put(key, cache);
    }


    public synchronized void putCacheInfo(String key, Object obj, long dt) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setExpired(false);
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        cacheMap.put(key, cache);
    }


    public synchronized void putCacheInfo(String key, Object obj) {
        putCacheInfo(key, obj, defaultDt);
    }


    public synchronized boolean cacheExpired(Cache cache) {
        if (null == cache) {
            return false;
        }

        long nowDT = System.currentTimeMillis();        // 系统当前的毫秒数
        long cacheDT = cache.getTimeOut();              // 缓存内的过期毫秒数
        return !(cacheDT <= 0 || cacheDT > nowDT);
    }


    public int getCacheSize() {
        return cacheMap.size();
    }


    public synchronized int getCacheSize(String type) {
        int size = 0;
        Iterator i = cacheMap.entrySet().iterator();
        String key;
        try {
            while (i.hasNext()) {
                Map.Entry entry = (Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.contains(type)) {
                    size++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return size;
    }


    public synchronized List getCacheAllKey() {
        List list = new ArrayList();

        Iterator iterator = cacheMap.keySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            list.add(entry.getKey());
        }

        return list;
    }


    public synchronized List getCacheListKey(String type) {
        List list = new ArrayList();

        Iterator iterator = cacheMap.keySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            if (key.contains(type)) {
                list.add(key);
            }
        }

        return list;
    }
}
