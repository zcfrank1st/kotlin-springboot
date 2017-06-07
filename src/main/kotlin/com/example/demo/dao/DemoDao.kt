package com.example.demo.dao

import com.example.demo.dao.mapper.gen.FirstScreenMapper
import com.example.demo.model.gen.FirstScreen
import com.example.demo.model.gen.FirstScreenExample
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by zcfrank1st on 07/06/2017.
 */
@Repository
class DemoDao {
    @Autowired
    lateinit var firstScreenMapper: FirstScreenMapper

    fun queryDemo():List<FirstScreen> {
        val firstScreenExample: FirstScreenExample = FirstScreenExample()
        return firstScreenMapper.selectByExample(firstScreenExample)
    }
}