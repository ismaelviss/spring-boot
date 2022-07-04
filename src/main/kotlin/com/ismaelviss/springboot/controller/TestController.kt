package com.ismaelviss.springboot.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TestController {

    @RequestMapping
    @ResponseBody
    fun function() : ResponseEntity<String> {
        return ResponseEntity("Hello form my controller, cambio", HttpStatus.OK)
    }
}