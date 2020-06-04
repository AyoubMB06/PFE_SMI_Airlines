package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_vols_styled.*

class VolsStyled : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vols_styled) //Affichage de la vue

        //Appel à la var DatabaseHelper
        handler = DatabaseHelper(this)
        val ss:String = intent.getStringExtra("nom")

        //Insertion des infos des vols dans la BD:
        /*handler.insertContrat("2020-100","MOSELLE","LORRAINE","20/05/20 12:00 PM",10000)
        handler.insertContrat("2020-200","LORRAINE","MOSELLE","21/05/20 06:15 AM",9500)
        handler.insertContrat("2020-300","SARRE","ALSACE","25/05/20 01:30 AM",7000)
        handler.insertContrat("2020-400","ALSACE","MOSELLE","06/06/20 09:15 PM",12000)*/

        //Détermination des boutons où pour chaque vol on fait passer son id
        vol1.setOnClickListener{
            val intent = Intent(applicationContext, Contrat1::class.java)
            intent.putExtra("nom1",ss)
            intent.putExtra("nom2",ss)
            intent.putExtra("num","2020-100")
            startActivity(intent)
        }
        vol2.setOnClickListener{
            val intent = Intent(applicationContext, Contrat1::class.java)
            intent.putExtra("nom1",ss)
            intent.putExtra("nom2",ss)
            intent.putExtra("num","2020-200")
            startActivity(intent)
        }
        vol3.setOnClickListener{
            val intent = Intent(applicationContext, Contrat1::class.java)
            intent.putExtra("nom1",ss)
            intent.putExtra("nom2",ss)
            intent.putExtra("num","2020-300")
            startActivity(intent)
        }
        vol4.setOnClickListener{
            val intent = Intent(applicationContext, Contrat1::class.java)
            intent.putExtra("nom1",ss)
            intent.putExtra("nom2",ss)
            intent.putExtra("num","2020-400")
            startActivity(intent)
        }

    }
}