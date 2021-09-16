package com.demo.springcloud.service.Impl;

import com.demo.springcloud.dao.StorageDao;
import com.demo.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println("storage 库存减少");
        storageDao.decrease(productId,count);
    }
}
