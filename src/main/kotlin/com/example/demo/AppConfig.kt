package com.example.demo

import com.google.gson.Gson
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 07/06/2017.
 */
@Configuration
@MapperScan(basePackages = arrayOf("com.example.demo.dao.mapper"), sqlSessionFactoryRef = "sqlSessionFactory")
class AppConfig {
    @Bean
    fun hikariConfig(): HikariConfig {
        val hikariConfig: HikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = "jdbc:mysql://192.168.33.229:3306/theme?useSSL=false"
        hikariConfig.username = "djdev"
        hikariConfig.password = "djDev123456;"

        return hikariConfig
    }


    @Bean(destroyMethod = "close")
    fun dataSource(): DataSource {
        return HikariDataSource(hikariConfig())
    }

    @Bean
    fun sqlSessionFactory(): SqlSessionFactory {
        val sqlSessionFactoryBean: SqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource())
        return sqlSessionFactoryBean.`object`
    }

    @Bean
    fun gson(): Gson = Gson()
}