package dev.davidvega.elsol

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String


class CompararPlanetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comparar_planetas)


        val listaPlanetas = arrayListOf(
            Planeta( "Mercurio", 0.382, 0.387, 5400 ),
            Planeta( "Venus", 0.949, 0.723, 5250 ),
            Planeta( "Tierra", 1.0, 1.0, 5520 ),
            Planeta( "Marte", 0.53, 1.542, 3960 ),
            Planeta( "Júpiter", 11.2, 5.203, 1350 ),
            Planeta( "Saturno", 9.41, 9.539, 700 ),
            Planeta( "Urano", 3.38, 19.81, 1200 ),
            Planeta( "Neptuno", 3.81, 30.07, 1500 ),
            Planeta( "Plutón", null, 39.44, 5 )
        )

        val adapterIzq = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, listaPlanetas
        )

        var autocompleteIzq = findViewById(R.id.autocomplete_izq) as AutoCompleteTextView

        var diametroIzq = findViewById(R.id.diametro_izq) as TextView
        var distanciasolIzq = findViewById(R.id.distanciasol_izq) as TextView
        var densidadIzq = findViewById(R.id.densidad_izq) as TextView

        autocompleteIzq.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = autocompleteIzq.getAdapter().getItem(position) as Planeta
            diametroIzq.setText(planetaSeleccionado.diametro.toString())
            distanciasolIzq.setText(String.valueOf(planetaSeleccionado.distanciaSol))
            densidadIzq.setText(planetaSeleccionado.densidad.toString())
        }
        autocompleteIzq.setAdapter(adapterIzq)

        val adapterDer = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, listaPlanetas
        )

        var autocompleteDer = findViewById(R.id.autocomplete_der) as AutoCompleteTextView

        var diametroDer = findViewById(R.id.diametro_der) as TextView
        var distanciasolDer = findViewById(R.id.distanciasol_der) as TextView
        var densidadDer = findViewById(R.id.densidad_der) as TextView

        autocompleteDer.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = autocompleteDer.getAdapter().getItem(position) as Planeta
            diametroDer.setText(planetaSeleccionado.diametro.toString())
            distanciasolDer.setText(String.valueOf(planetaSeleccionado.distanciaSol))
            densidadDer.setText(planetaSeleccionado.densidad.toString())
        }
        autocompleteDer.setAdapter(adapterDer)



    }
}