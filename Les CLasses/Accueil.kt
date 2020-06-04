package com.mb.appgestionvols

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_accueil.*

class Accueil : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)

        //Définition des différents boutons de notre vue 'layout.activity_accueil'
        profil.setOnClickListener(this)
        vols.setOnClickListener(this)
        pilotes.setOnClickListener(this)
        avions.setOnClickListener(this)
        historique.setOnClickListener(this)
        logout.setOnClickListener(this)
    }

    //Surcharge de la fonction onClick pour qu'on puisse traiter chaque partie
    override fun onClick(v: View) {
        //On peut distinguer les parties grâce aux ids:
        when (v.id) {
            R.id.profil -> {
                //Si l'utilisateur choisit le profil, on le redirectionne au profil avec une clé contenant l'id
                val ss:String = intent.getStringExtra("login") //récupération de l'id
                val intent = Intent(applicationContext, ProfilApp::class.java)
                intent.putExtra("profil_id",ss) //Envoi de l'id vers l'activité suivante
                startActivity(intent) //Démarrage de l'acitivité suivante
            }
            R.id.vols -> {
                //idem
                val ss:String = intent.getStringExtra("login")
                val intent = Intent(applicationContext, VolsStyled::class.java)
                intent.putExtra("nom",ss)
                startActivity(intent)
            }
            R.id.pilotes -> {
                //idem
                val intent = Intent(applicationContext, Avions::class.java)
                startActivity(intent)
            }
            R.id.avions -> {
                //idem
                val intent = Intent(applicationContext, Pilotes::class.java)
                startActivity(intent)
            }
            R.id.historique -> {
                //idem
                val intent = Intent(applicationContext, Historique1::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                //Lors de la déconnexion, on redirige le client vers la page d'authentification
                Toast.makeText(this,"A bientôt", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onBackPressed() {

    }

}