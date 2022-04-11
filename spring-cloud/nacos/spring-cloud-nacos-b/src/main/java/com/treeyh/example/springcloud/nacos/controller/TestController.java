package com.treeyh.example.springcloud.nacos.controller;

import com.treeyh.example.springcloud.nacos.model.ReturnResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: hai.yu
 * @version: 1.0
 * @description:
 * @create: 2020-11-17 17:56
 * @email: tree@ejyi.com
 **/
@RequestMapping(value = "/api/v1")
@RestController
public class TestController {

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = {"/test"},
            method = {RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReturnResult<String> createUser(@RequestParam(required = true, name="id", defaultValue = "123") String id) {

        ReturnResult<String> result = ReturnResult.<String>builder().code(0).message("ok").data(this.getHostIp()+ " B-1 " + port + " "+System.currentTimeMillis()).build();


        return result;
    }


    private String getHostIp() {

        String IP = "";
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

        }
        return IP;
    }

}
