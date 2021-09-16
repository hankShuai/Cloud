package com.demo.springcloud.dao;


import com.demo.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void createOrder(Order order);


    //2修改订单状态
    void  update(@Param("userId")Long userId,@Param("status")Integer status);
}
