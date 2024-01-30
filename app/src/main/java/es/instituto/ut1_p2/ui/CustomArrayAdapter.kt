package es.instituto.pmdm_ut1_p2.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import es.instituto.pmdm_ut1_p2.model.Persona
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import es.instituto.ut1_p2.DetailActivity
import es.instituto.ut1_p2.R

class CustomArrayAdapter(private val context: Context, private val repository: PersonasRepository) :
    BaseAdapter() {
    private lateinit var nombre: TextView
    private lateinit var button: Button
    private lateinit var borrar: ImageButton
    private lateinit var contactos : ArrayList <Persona>;

    override fun getCount(): Int {
        return this.contactos.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    fun find(textbuscar:String){
        if (textbuscar.equals("")){
            contactos = repository.getAll()
        }else{
            contactos = ArrayList<Persona>(repository.getAll().filter{contacto ->
                    contacto.getNombre().contains(textbuscar) ||
                    contacto.getApellidos().contains(textbuscar) ||
                    contacto.getEmail().contains(textbuscar) ||
                    contacto.getTelefono().contains(textbuscar)})
        }
        notifyDataSetChanged()
    }
    init {
        this.contactos = repository.getAll()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)

        nombre = convertView.findViewById(R.id.textView)
        //Este es el boton para editar un contacto
        button = convertView.findViewById(R.id.button2)
        button.setOnClickListener {
            var posicion = position
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra("posicion",posicion)
            parent.context.startActivity(intent)
        }



         borrar= convertView.findViewById(R.id.borrar)
         borrar.setOnClickListener {
             val nombrecito = this.contactos[position].getNombre()
             //se borra de la copia
             this.contactos.removeAt(position)
             //se borra del original
             this.repository.getAll().forEach{ persona -> if (persona.getNombre().equals(nombrecito) )  {this.repository.getAll().remove(persona)} }
             //se avisa de lso cambios
             this.notifyDataSetChanged();
         }

         nombre.text =  this.contactos[position].getNombre()
        return convertView
    }
}