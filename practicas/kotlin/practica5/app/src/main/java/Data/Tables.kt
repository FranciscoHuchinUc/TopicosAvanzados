package Data

import Models.User

class Tables {
    abstract class Users{
        companion object{
            val _ID = "_id"
            val TABLE_NAME = "usuarios"
            val USUARIO = "usuario"
            val PASSWORD = "password"
            var users: MutableList<User> = ArrayList()
        }
    }
}