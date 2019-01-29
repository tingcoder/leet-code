package com.tingcoder.base.cache;

import lombok.AllArgsConstructor;
import org.junit.Test;
import sun.misc.Cleaner;

import java.util.concurrent.TimeUnit;

/***
 * @author yfeng
 * @date 2019-01-29 17:51
 */
public class PhantomReferenceTest {

    @AllArgsConstructor
    private class RemoveTask implements Runnable {
        private Long key;
        private String value;

        public void run() {
            System.out.println(String.format("对象被回收 key: %d value: %s", key, value));
        }
    }

    @Test
    public void testPhantomReference() {
        PhantomReferenceTest ins = new PhantomReferenceTest();
        Cleaner.create(ins, new RemoveTask(12L, "12-value"));
        ins = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}