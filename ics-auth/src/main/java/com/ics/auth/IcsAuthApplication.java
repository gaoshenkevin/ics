package com.ics.auth;

import com.ics.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证授权中心
 * 
 * @author Kevin
 */
@EnableRyFeignClients
@SpringBootApplication
public class IcsAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(IcsAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
