package com.tingcoder.base.cache;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/***
 * @author yfeng
 * @date 2019-01-29 15:32
 */
@Slf4j
public class CacheLoaderTest {

    private LoadingCache<Long, String> cache;

    private Map<Long, String> db = new HashMap();

    @Before
    public void init() {
        log.info("开始初始化操作 ......");
        //初始化数据库
        for (int i = 1; i < 1000; i++) {
            db.put((long) i, "name-" + i);
        }

        cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .removalListener(new RemovalListener<Long, String>() {
                    public void onRemoval(RemovalNotification<Long, String> notification) {
                        Long key = notification.getKey();
                        String value = notification.getValue();
                        System.out.println(String.format("监听: key:%d value:%s 被删除....", key, value));
                    }
                })
                .build(new CacheLoader<Long, String>() {
                    @Override
                    public String load(Long key) throws Exception {
                        log.info("从db中查询:{}", key);
                        return db.get(key);
                    }
                });
    }

    @Test
    public void testEvictData() {
        for (int i = 1; i <= 50; i++) {
            try {
                cache.get((long) i);
            } catch (ExecutionException e) {
                log.error(e.getMessage(), e);
            }
        }

        cache.invalidate(10L);

        System.out.println("测试完成");
    }

    @Test
    public void testWriteData() {
        for (int i = 1; i < 1000; i++) {
            try {
                cache.get((long) i);
            } catch (ExecutionException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}