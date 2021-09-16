package com.demo.springcloud.service.Impl;

import com.demo.springcloud.dao.AccountDao;
import com.demo.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("账户扣减成功");
        accountDao.decrease(userId,money);
    }
}
