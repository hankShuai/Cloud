package com.demo.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    void decrease (@Param("productId")Long ProductId,
                   @Param("count") Integer count);
}
