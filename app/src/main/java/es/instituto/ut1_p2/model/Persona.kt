package es.instituto.pmdm_ut1_p2.model

class Persona {
    private var nombre: String = ""
    private var apellidos: String = ""
    private var email: String = ""
    private var activo: Boolean = false
    private var telefono:String=""
    constructor(nombre: String, apellidos: String, email: String, telefono:String,activo: Boolean) {
        this.nombre = nombre
        this.apellidos = apellidos
        this.email = email
        this.activo = activo
        this.telefono=telefono
    }
    constructor() {

    }
    // Getter para el atributo nombre
    fun getNombre(): String {
        return nombre
    }

    // Setter para el atributo nombre
    fun setNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    // Getter para el atributo apellidos
    fun getApellidos(): String {
        return apellidos
    }

    // Setter para el atributo apellidos
    fun setApellidos(nuevosApellidos: String) {
        apellidos = nuevosApellidos
    }

    // Getter para el atributo email
    fun getEmail(): String {
        return email
    }

    // Setter para el atributo email
    fun setEmail(nuevoEmail: String) {
        email = nuevoEmail
    }

    // Getter para el atributo email
    fun getTelefono(): String {
        return telefono
    }

    // Setter para el atributo email
    fun setTelefono(nuevo: String) {
        telefono = nuevo
    }
    // Getter para el atributo activo
    fun isActivo(): Boolean {
        return activo
    }

    // Setter para el atributo activo
    fun setActivo(nuevoActivo: Boolean) {
        activo = nuevoActivo
    }

    // Método clone para crear una copia de la Persona
    public fun clone(): Persona {
        val nuevaPersona = Persona()
        nuevaPersona.nombre = this.nombre
        nuevaPersona.apellidos = this.apellidos
        nuevaPersona.email = this.email
        nuevaPersona.activo = this.activo
        nuevaPersona.telefono=this.telefono
        return nuevaPersona
    }

    // Método equals para comparar dos objetos Persona
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val otraPersona = other as Persona

        if (nombre != otraPersona.nombre) return false
        if (apellidos != otraPersona.apellidos) return false
        if (email != otraPersona.email) return false
        if (telefono != otraPersona.telefono) return false
        if (activo != otraPersona.activo) return false

        return true
    }

    // Método hashCode para garantizar consistencia con equals
    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + apellidos.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + telefono.hashCode()

        result = 31 * result + activo.hashCode()
        return result
    }
}