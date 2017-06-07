package com.example.demo.controller

import com.example.demo.service.HelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by zcfrank1st on 07/06/2017.
 */
@RestController
@RequestMapping("hello")
class HelloController {
    @Autowired
    lateinit var helloService: HelloService

    @GetMapping("/string")
    fun helloString() = helloService.getHello()

    @GetMapping("/string1")
    fun helloString1() = helloService.getHello1()

}