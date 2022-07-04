package com.ismaelviss.springboot.configuration

import com.ismaelviss.springboot.bean.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfigurationBean {

    @Bean
    fun beanMyBean() : MyBean {
        return MyBeanImplement()
    }

    @Bean
    fun beanMyOperation() : MyOperation {
        return MyOperationImplement()
    }

    @Bean
    fun beanMyBeanWithOperation(myOperation: MyOperation) : MyBeanWithOperation {
        return MyBeanWithOperationImplement(myOperation)
    }
}