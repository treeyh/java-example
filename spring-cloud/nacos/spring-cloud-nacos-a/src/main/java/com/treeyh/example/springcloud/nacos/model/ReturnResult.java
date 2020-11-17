package com.treeyh.example.springcloud.nacos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: hai.yu
 * @version: 1.0
 * @description:
 * @create: 2020-11-17 17:59
 * @email: hai.yu@snowballtech.com
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;


}
