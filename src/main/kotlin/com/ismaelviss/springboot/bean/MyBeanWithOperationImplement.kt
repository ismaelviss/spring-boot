package com.ismaelviss.springboot.bean

import com.ismaelviss.springboot.Application
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class MyBeanWithOperationImplement(private val myOperation: MyOperation)
    : MyBeanWithOperation {

    private val log: Log = LogFactory.getLog(MyBeanWithOperationImplement::class.java)

    override fun printWithDependency() {
        log.info("number = 1")
        val number = 1
        log.debug("se seteo uno")
        println(myOperation.sum(number))
        println("hola desde la implementacion de un bean con dependencia")
    }
}