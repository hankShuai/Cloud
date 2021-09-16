package com.demo.springcloud.myHandller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.entities.CommonResult;

public class mBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "客户字自定义", "\t服务不可用");
    }
}
