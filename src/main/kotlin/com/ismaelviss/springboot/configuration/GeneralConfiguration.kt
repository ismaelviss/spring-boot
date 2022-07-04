package com.ismaelviss.springboot.configuration

import com.ismaelviss.springboot.bean.MyBeanWithProperties
import com.ismaelviss.springboot.bean.MyBeanWithPropertiesImplement
import com.ismaelviss.springboot.pojo.UserPojo
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo::class)
class GeneralConfiguration {

    @Value("\${value.name}")
    private lateinit var name: String

    @Value("\${value.apellido}")
    private lateinit var apellido: String

    @Value("\${value.random}")
    private lateinit var random: String

    @Value("\${jdbc.url}")
    private lateinit var url: String

    @Value("\${driver}")
    private lateinit var driver: String

    @Value("\${username}")
    private lateinit var username: String

    @Value("\${password}")
    private lateinit var password: String

    @Bean
    fun function() : MyBeanWithProperties {
        return MyBeanWithPropertiesImplement(name, apellido)
    }

    @Bean
    fun dataSource() : DataSource {
        val dataSourceBuilder = DataSourceBuilder.create()
        /*dataSourceBuilder.driverClassName("org.h2.Driver")
        dataSourceBuilder.url("jdbc:h2:mem:testdb")
        dataSourceBuilder.username("SA")
        dataSourceBuilder.password("")*/

        dataSourceBuilder.driverClassName(driver)
        dataSourceBuilder.url(url)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)

        return dataSourceBuilder.build()
    }
}