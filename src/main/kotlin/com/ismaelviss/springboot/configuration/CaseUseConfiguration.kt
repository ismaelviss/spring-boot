package com.ismaelviss.springboot.configuration

import com.ismaelviss.springboot.caseUse.GetUser
import com.ismaelviss.springboot.caseUse.GetUserImplement
import com.ismaelviss.springboot.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CaseUseConfiguration {

    @Bean
    fun getUserImplement(userService: UserService) : GetUser {
        return GetUserImplement(userService)
    }
}