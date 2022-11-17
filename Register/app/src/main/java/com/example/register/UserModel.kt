package com.example.register

import java.util.*

data class UserModel (
    var id: Int = getAutoId(),
    var name: String = "",
    var email: String = ""
        ){
        companion object {
            fun getAutoId(): Int{
                val random = Random()
                return random.nextInt(100)
            }
        }


}