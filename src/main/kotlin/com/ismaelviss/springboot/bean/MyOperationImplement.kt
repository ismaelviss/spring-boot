package com.ismaelviss.springboot.bean

class MyOperationImplement : MyOperation {
    override fun sum(number: Int): Int {
        return number + 1
    }
}