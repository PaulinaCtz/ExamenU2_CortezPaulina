package mx.edu.itson.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class Regalos : AppCompatActivity() {
    var adapter: DetallesAdapter? = null
    var detallesT=ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        val gridview: GridView = findViewById(R.id.gridview)

        cargarDetalles()
        adapter=DetallesAdapter(this, detallesT)
        gridview.adapter = adapter

    }

    fun cargarDetalles(){
        detallesT.add(Detalles(R.drawable.cumplebotanas, "Detalle", "250"))
        detallesT.add(Detalles(R.drawable.cumplecheve, "Detalle", "250"))
        detallesT.add(Detalles(R.drawable.cumpleescolar, "Detalle", "250"))
        detallesT.add(Detalles(R.drawable.cumplepaletas, "Detalle", "250"))
        detallesT.add(Detalles(R.drawable.cumplesnack, "Detalle", "250"))
        detallesT.add(Detalles(R.drawable.cumplevinos, "Detalle", "250"))
    }

    class DetallesAdapter: BaseAdapter {

        var productos = ArrayList<Detalles>()
        var contexto: Context? =null

        constructor(contexto: Context, pelicula: ArrayList<Detalles>){
            this.productos = pelicula
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflator=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            var vista=inflator.inflate(R.layout.detalle,null)

            var imagen = vista.findViewById(R.id.iv_detalle) as ImageView
            var nombre = vista.findViewById(R.id.iv_titulo) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.titulo)

            imagen.setOnClickListener(){
                val intento = Intent(contexto,DetalleRegalos::class.java)
                intento.putExtra("titulo",prod.titulo)
                intento.putExtra("imagen",prod.image)
                contexto!!.startActivity(intento)
            }
            return vista
        }

    }
}