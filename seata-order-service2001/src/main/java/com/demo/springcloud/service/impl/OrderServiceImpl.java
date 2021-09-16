package com.demo.springcloud.service.impl;

import com.demo.springcloud.dao.OrderDao;
import com.demo.springcloud.domain.Order;
import com.demo.springcloud.service.AccountService;
import com.demo.springcloud.service.OrderService;
import com.demo.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "name=fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("------>开始新建订单");
        orderDao.createOrder(order);
        log.info("------>开始调用库存,扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("账户余额扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());

        //修改订单状态
        log.info("---->修改订单状态");
        orderDao.update(order.getUserId(),0);
    }
}
