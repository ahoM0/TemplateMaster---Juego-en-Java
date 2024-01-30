package es.instituto.ut1_p2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import es.instituto.pmdm_ut1_p2.AgendaApp
import es.instituto.pmdm_ut1_p2.model.Persona
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import es.instituto.pmdm_ut1_p2.ui.CustomArrayAdapter
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var personasrepositor: PersonasRepository
    lateinit var personaEditable: Persona
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //injección de dependecias
        (applicationContext as AgendaApp).appComponent.inject(this)

        val posicion = intent.getSerializableExtra("posicion") as Int

        if (posicion != -1){
            //Muestra los datos de la persona que vamos a editar
            mostrarDatos(posicion)
        }

        // Acepta los datos y los edita o añade depende del boton con el
        // que accedio
        (findViewById<Button>(R.id.aceptarButton)).setOnClickListener(){
            if (posicion != -1){
                this.personasrepositor.getAll()[posicion].setNombre(findViewById<TextView>(R.id.editTextNombre).text.toString())
                this.personasrepositor.getAll()[posicion].setApellidos(findViewById<TextView>(R.id.editTextApellidos).text.toString())
                this.personasrepositor.getAll()[posicion].setEmail(findViewById<TextView>(R.id.editTextEmail).text.toString())
                this.personasrepositor.getAll()[posicion].setTelefono(findViewById<TextView>(R.id.editTextTelefono).text.toString())
                if (findViewById<CheckBox>(R.id.editActivo).isChecked){
                    this.personasrepositor.getAll()[posicion].setActivo(true)
                }else{
                    this.personasrepositor.getAll()[posicion].setActivo(false)
                }
            }else{
                var personaNueva:Persona = Persona()
                personaNueva.setNombre(findViewById<TextView>(R.id.editTextNombre).text.toString())
                personaNueva.setApellidos(findViewById<TextView>(R.id.editTextApellidos).text.toString())
                personaNueva.setEmail(findViewById<TextView>(R.id.editTextEmail).text.toString())
                personaNueva.setTelefono(findViewById<TextView>(R.id.editTextTelefono).text.toString())

                // FUncion que comprueba si uno de los campos esta vacio
                //Si esta vacion no quiero que se cree el contacto
                if (esValido(personaNueva)){
                    this.personasrepositor.add(personaNueva)
                }else{
                    finish()
                }
            }
            finish();
        }

        //se vuelve atras
        (findViewById<Button>(R.id.cancelarButton)).setOnClickListener(){
            finish();
        }


    }
    fun mostrarDatos(pos:Int){
        findViewById<TextView>(R.id.editTextNombre).setText(this.personasrepositor.getAll().get(pos).getNombre())
        findViewById<TextView>(R.id.editTextApellidos).setText(this.personasrepositor.getAll().get(pos).getApellidos())
        findViewById<TextView>(R.id.editTextEmail).setText(this.personasrepositor.getAll().get(pos).getEmail())
        findViewById<TextView>(R.id.editTextTelefono).setText(this.personasrepositor.getAll().get(pos).getTelefono())
        if (this.personasrepositor.getAll().get(pos).isActivo()) {
            val bola = findViewById<CheckBox>(R.id.editActivo)
            bola.isChecked = true
        }
    }

    fun esValido(persona: Persona): Boolean{
        if (persona.getNombre() == "" || persona.getApellidos() == "" || persona.getEmail()=="" || persona.getTelefono() == ""){
            return false
        }

        return true
    }

}