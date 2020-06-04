package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Vols : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil_app)

        var listview = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(Model("MOSELLE TO LORRAINE    10.000 MAD","20/05/2020 12:00PM",R.drawable.vol11))
        list.add(Model("LORRAINE TO MOSELLE    9500 MAD","21/05/2020 06:15AM",R.drawable.vol22))
        list.add(Model("SARRE TO ALSACE         7000 MAD","25/05/2020 01:30AM",R.drawable.vol33))
        list.add(Model("ALSACE TO MOSELLE    12.000 MAD","06/06/2020 09:15PM",R.drawable.vol44))

        listview.adapter = MyAdapter(this, R.layout.activity_accueil_app, list)

        listview.setOnItemClickListener {
                parent: AdapterView<*>, view: View, position: Int, id: Long ->
            if (position == 0){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var vol1 = Intent(this, Contrat1::class.java)
                startActivity(vol1)
            }
            if (position == 1){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var vol2 = Intent(this, Contrat1::class.java)
                startActivity(vol2)
            }
            if (position == 2){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var vol3 = Intent(this, Contrat1::class.java)
                startActivity(vol3)
            }
            if (position == 3){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var vol4 = Intent(this, Contrat1::class.java)
                startActivity(vol4)
            }

        }


    }

}

