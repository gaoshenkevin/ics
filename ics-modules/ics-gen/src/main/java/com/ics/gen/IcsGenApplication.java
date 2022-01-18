package com.ics.gen;

import com.ics.common.swagger.annotation.EnableCustomSwagger3;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.ics.common.security.annotation.EnableCustomConfig;
import com.ics.common.security.annotation.EnableRyFeignClients;

/**
 * 代码生成
 * 
 * @author Kevin
 */
@EnableCustomConfig
@EnableCustomSwagger3
@EnableRyFeignClients
@SpringCloudApplication
public class IcsGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(IcsGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
