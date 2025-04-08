package org.ztc.javaproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ztc.javaproject.annotation.TimeStampRequestBody;

import java.util.Map;

/**
 * @author: zhangtc
 * @date: 2025/4/8 16:51
 * @description:
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @PostMapping
    public Map<String, Object> origin(@TimeStampRequestBody Map<String, Object> json) {
        return json;
    }
}
