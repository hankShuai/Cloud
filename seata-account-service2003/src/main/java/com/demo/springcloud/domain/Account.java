package com.demo.springcloud.domain;

import lombok.Data;

import java.math.BigDecimal;

//id  user_id  total   used    residue
@Data
public class Account {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private Integer used;

    /**
     * 剩余额度
     */
    private Integer residue;
}