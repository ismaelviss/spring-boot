package com.ismaelviss.springboot.pojo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(
    prefix = "user"
)
class UserPojo(
    var email: String,
    var password: String,
    var age: Int
)