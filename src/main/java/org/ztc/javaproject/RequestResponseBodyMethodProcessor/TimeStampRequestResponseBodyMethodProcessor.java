package org.ztc.javaproject.RequestResponseBodyMethodProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.ztc.javaproject.annotation.TimeStampRequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author: zhangtc
 * @date: 2025/4/8 17:50
 * @description:
 */
public class TimeStampRequestResponseBodyMethodProcessor implements HandlerMethodArgumentResolver {

    private RequestResponseBodyMethodProcessor processor;

    private ApplicationContext applicationContext;

    public TimeStampRequestResponseBodyMethodProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TimeStampRequestBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        setupProcessor();
        final Object obj = processor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        if (!(obj instanceof Map<?, ?>)) {
            return obj;
        }
        ((Map) obj).put("timestamp", System.currentTimeMillis());
        return obj;
    }

    private void setupProcessor() {
        final List<HandlerMethodArgumentResolver> argumentResolvers = this.applicationContext.getBean(RequestMappingHandlerAdapter.class).getArgumentResolvers();
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            if (argumentResolver instanceof RequestResponseBodyMethodProcessor) {
                this.processor = (RequestResponseBodyMethodProcessor) argumentResolver;
                return;
            }
        }
    }
}
