package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historique.*

class Historique : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historique)

        //Récupération des données depuis la page de confirmation
        val num: String = intent.getStringExtra("numero")
        val date: String = intent.getStringExtra("date")
        val deparr: String = intent.getStringExtra("dep_arr")
        val prix: String = intent.getStringExtra("prix")
        //Actualisation des champs setText()
        hist_num.setText(num)
        hist_date.setText(date)
        hist_deparr.setText(deparr)
        hist_prix.setText(prix)

        //Le bouton revenir à la page d'accueil possedant qlq clés des ids:
        butt_accueil.setOnClickListener{
            val ss:String = intent.getStringExtra("login_hist")
            val intent = Intent(applicationContext, Accueil::class.java)
            intent.putExtra("login", ss)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {

    }
}