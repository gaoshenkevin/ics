package com.ics.system;

import com.ics.common.security.annotation.EnableCustomConfig;
import com.ics.common.security.annotation.EnableRyFeignClients;
import com.ics.common.swagger.annotation.EnableCustomSwagger3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统模块
 * 
 * @author Kevin
 */
@EnableCustomConfig
@EnableCustomSwagger3
@EnableRyFeignClients
@SpringBootApplication
public class IcsSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(IcsSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
