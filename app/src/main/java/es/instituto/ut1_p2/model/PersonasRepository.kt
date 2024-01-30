package es.instituto.pmdm_ut1_p2.model
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class PersonasRepository {
    private var contactos: ArrayList<Persona> = ArrayList()

    @Inject constructor(){


    }
    fun add(item:Persona) {
        this.contactos.add(item)
    }

    fun editar(item:Persona){

    }

    fun getAll():ArrayList<Persona>{
        return this.contactos;
    }



    fun remove(index:Int):Persona{

        // this.contactos.removeif()
        return this.contactos.removeAt(index);
    }

}