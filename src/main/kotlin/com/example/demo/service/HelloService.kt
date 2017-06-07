package com.example.demo.service

import com.example.demo.dao.DemoDao
import com.example.demo.model.gen.FirstScreen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by zcfrank1st on 07/06/2017.
 */
@Service
class HelloService {
    @Autowired
    lateinit var gson: Gson
    @Autowired
    lateinit var demoDao: DemoDao

    fun getHello(): String = gson.toJson(demoDao.queryDemo(), object : TypeToken<List<FirstScreen>>() {}.type)

    fun getHello1() = demoDao.queryDemo()
}