package Models

class User {

    private var id: Int = 0
    private var usuario: String = ""
    private var password: String = ""

    constructor(id: Int, usuario: String, password: String) {
        this.id = id
        this.usuario = usuario
        this.password = password
    }

    fun getId(): Int {
        return id
    }

    fun getUsuario(): String {
        return usuario
    }

    fun getPassword(): String {
        return password
    }

    override fun toString(): String {
        return usuario + " - " + password
    }

}