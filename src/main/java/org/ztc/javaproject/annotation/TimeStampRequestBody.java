package org.ztc.javaproject.annotation;

import java.lang.annotation.*;

/**
 * @author: zhangtc
 * @date: 2025/4/8 17:52
 * @description:
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeStampRequestBody {
}
