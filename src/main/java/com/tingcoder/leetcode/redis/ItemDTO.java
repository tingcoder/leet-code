package com.tingcoder.leetcode.redis;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ItemDTO implements Serializable {

    private Long id;
    private String name;
    private String imgUrl;
    private Long storeId;
    private Long brandId;
    private Long categoryId;
    private BigDecimal promotionPrice;
    private BigDecimal originPrice;
    private String desc;
    private boolean haitao;
    private Integer integralRatio;

}