package com.cpp288.demo.oauth.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * demo controller
 *
 * @author chenjian
 * @date 2021/1/13 下午3:29
 */
@RestController
public class DemoController {

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    //演示登录后才能访问的安全页面
    @GetMapping("/securedPage")
    public ModelAndView securedPage(OAuth2Authentication authentication) {
        return new ModelAndView("securedPage").addObject("authentication", authentication);
    }

    //演示通过OAuth2RestTemplate调用受保护资源
    @GetMapping("/remoteCall")
    public String remoteCall() {
        ResponseEntity<String> responseEntity = oAuth2RestTemplate.getForEntity("http://localhost:8081/user/name", String.class);
        return responseEntity.getBody();
    }
}
