package com.ismaelviss.springboot.bean

class MyBeanWithPropertiesImplement(private var name: String, private var apellido: String) : MyBeanWithProperties {
    override fun function(): String {
        return "$name-$apellido"
    }

}
