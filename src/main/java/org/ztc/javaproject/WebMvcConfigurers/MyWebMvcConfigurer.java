package org.ztc.javaproject.WebMvcConfigurers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.ztc.javaproject.RequestResponseBodyMethodProcessor.TimeStampRequestResponseBodyMethodProcessor;

import java.util.List;

/**
 * @author: zhangtc
 * @date: 2025/4/8 18:32
 * @description:
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TimeStampRequestResponseBodyMethodProcessor(applicationContext));
    }
}
