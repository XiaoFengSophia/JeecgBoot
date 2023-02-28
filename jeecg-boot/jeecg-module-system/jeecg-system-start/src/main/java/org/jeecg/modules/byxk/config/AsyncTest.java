package org.jeecg.modules.byxk.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author:zxf
 * @create: 2023-02-27 16:42
 * @Description: 测试异步调用
 * @Company: 白云信科·研发中心·研发三室
 */
@Component
public class AsyncTest {

    @Async
    public void syncOut(){

        System.out.println("sync ThreadId：" + Thread.currentThread().getId());
    }
}
