package com.mb.appgestionvols

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_accueil.*
import kotlinx.android.synthetic.main.activity_main.*

class AccueilAdmin : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil_admin)

        profil.setOnClickListener(this)
        vols.setOnClickListener(this)
        pilotes.setOnClickListener(this)
        avions.setOnClickListener(this)
        historique.setOnClickListener(this)
        logout.setOnClickListener(this)
    }

    //Une page d'accueil pour l'administrateur, idem pour celle des clients, la seule différence est les pages de redirection
    override fun onClick(v: View) {
        when (v.id) {
            R.id.profil -> {
                val intent = Intent(applicationContext, AdminProfil::class.java)
                startActivity(intent)
            }
            R.id.vols -> {
                val intent = Intent(applicationContext, AdminVols::class.java)
                startActivity(intent)
            }
            R.id.pilotes -> {
                val intent = Intent(applicationContext, AdminPilotes::class.java)
                startActivity(intent)
            }
            R.id.avions -> {
                val intent = Intent(applicationContext, AdminAvions::class.java)
                startActivity(intent)
            }
            R.id.historique -> {
                val intent = Intent(applicationContext, Historique::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                Toast.makeText(this,"A bientôt", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onBackPressed() {

    }

}