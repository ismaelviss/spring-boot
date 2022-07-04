package com.ismaelviss.springboot.component

import org.springframework.stereotype.Component

@Component
class ComponentImplement : ComponentDependency {

    override fun greetMethod() {
        println("Hello world!")
    }

}