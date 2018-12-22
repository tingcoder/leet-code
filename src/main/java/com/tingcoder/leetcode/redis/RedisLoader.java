package com.tingcoder.leetcode.redis;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.Uninterruptibles;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class RedisLoader {
    private static ItemDTO item;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("lin-server", 6379);

        item = new ItemDTO();
        item.setBrandId(13333333L);
        item.setCategoryId(3544545L);
        item.setDesc("<img src='http://oss.motherbuy.com/shop/store/goods/796/a4bcb09e-ee1e-4417-8907-54fa5958a0b7.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/678ede06-788a-4b80-b4e3-9cb75b696bf0.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/acf40894-bd44-4538-8712-6665070832fb.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/daf06a44-db16-450e-83f0-ebf73e8913e7.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/324c735a-91e5-47fb-96e1-26a9d6413ea3.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/043cdeaf-e366-4a78-9d6d-1489ed0a8100.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/28e2d15c-c0d5-4951-8662-d8ebf7a191d7.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/ab1cf3bb-aecc-4039-a8e9-0631cb961980.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/0345643a-683d-4266-8059-8f6783e3017b.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/08562ec6-020f-4831-b901-e708ff7550d8.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/f34bfadf-62cf-464b-ae86-bb4ee8625303.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/a228e553-d816-4d02-86de-a3aac450dae3.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/11d0bc66-71e0-4a96-9764-a71ed3e88b77.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/c2d217de-1bdb-46e4-a761-84cccf4905a2.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/0b70f156-32fb-46a0-bdbc-93153fa86c32.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/d6e9d9fe-6c79-42a2-b3b2-05b3f854ba6c.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/3539841e-f0c8-4b2d-b851-a0803df6eb8e.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/e3227a5c-b2a5-4b89-b94f-713242354c1b.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/556ecea6-e726-41bb-bcb6-958dd564d6ea.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/4d208c24-6a8c-48e3-bbcc-5b881a9bcb13.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/bd73ba41-edac-465c-91cc-fcca6a8ac6f4.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/97347339-bdf2-416d-af9d-1c2423266c23.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/62ec0931-5d63-4eba-b50f-c1ebb3777b7a.jpg' alt='' />" +
                "<img src='http://oss.motherbuy.com/shop/store/goods/796/520deacd-b754-4d55-bc35-e030463b9eb7.jpg' alt='' />");
        item.setHaitao(false);
        item.setImgUrl("/shop/store/goods/796/556ecea6-e726-41bb-bcb6-958dd564d6ea.jpg");
        item.setName("曼妃新款床上用品时尚简约床品套件芦荟棉床单款四件套");
        item.setIntegralRatio(100);
        item.setStoreId(39234L);
        item.setId(233432342235235252L);
        item.setOriginPrice(new BigDecimal(200.99));
        item.setPromotionPrice(new BigDecimal(188.99));
        jedis.set("item-" + item.getId(), JSON.toJSONString(item));


        Uninterruptibles.sleepUninterruptibly(30, TimeUnit.MINUTES);
        System.out.println(JSON.toJSONString(item, true));
    }
}