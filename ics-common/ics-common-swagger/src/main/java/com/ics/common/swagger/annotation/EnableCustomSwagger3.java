package com.ics.common.swagger.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ics.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * 启用自定义swagger2
 *
 * @author Kevin
 * @date 2022-01-17
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ SwaggerAutoConfiguration.class })
public @interface EnableCustomSwagger3
{

}
