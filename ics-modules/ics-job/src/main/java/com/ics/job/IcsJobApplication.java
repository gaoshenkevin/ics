package com.ics.job;

import com.ics.common.swagger.annotation.EnableCustomSwagger3;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.ics.common.security.annotation.EnableCustomConfig;
import com.ics.common.security.annotation.EnableRyFeignClients;

/**
 * 定时任务
 * 
 * @author Kevin
 */
@EnableCustomConfig
@EnableCustomSwagger3
@EnableRyFeignClients
@SpringCloudApplication
public class IcsJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(IcsJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
