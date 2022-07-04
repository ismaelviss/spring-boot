package com.ismaelviss.springboot.component

import org.springframework.stereotype.Component

@Component
class ComponentTwoImplement : ComponentDependency {
    override fun greetMethod() {
        println("Hello world from ComponentTwoImplement")
    }
}