package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contrat1.*
import kotlinx.android.synthetic.main.activity_profil_app.*
import java.text.SimpleDateFormat
import java.util.*

class Contrat1 : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrat1)

        handler = DatabaseHelper(this)
        val ss1:String = intent.getStringExtra("nom2") //Récupération de l'id

        afficherContrat()
        handleViewing()

        //Définition des étapes lors de la confirmation du vol:
        c1.setOnClickListener{
            Toast.makeText(this,"Téléchargement réussi", Toast.LENGTH_SHORT).show() //Affichage du message
            val intent = Intent(applicationContext, Historique::class.java) //Redirection vers la page de confirmation
            intent.putExtra("numero", tck_num.text.toString()) //On fait passer les diff infos
            intent.putExtra("date", tck_dateRes.text.toString())
            intent.putExtra("dep_arr", tck_dep.text.toString() + "-" + tck_arr.text.toString())
            intent.putExtra("prix", tck_prix.text.toString())
            intent.putExtra("login_hist", ss1)
            startActivity(intent)
        }
    }

    //Fonction qui fait appel aux informations depuis la base de données pour les afficher avec la vue "layout.activity_contrat1"
    fun afficherContrat() {
        val num: String = intent.getStringExtra("num")

        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date1 = simpleDateFormat.format(Date())

        val res1 = handler.showVols(num)
        if (res1.moveToFirst()) {
            //Idem pour les autres classes
            val depart: String = res1.getString(2)
            val arrivee: String = res1.getString(3)
            val date: String = res1.getString(4)
            val prix: String = res1.getString(5)
            tck_dep.setText(depart)
            tck_arr.setText(arrivee)
            tck_dateDep.setText(date)
            tck_prix.setText(prix + " MAD")
            tck_num.setText(num)
            tck_dateRes.setText(date1)
        }
    }
    //Récupération du nom et prénom du client:
    fun handleViewing() {
        val ss:String = intent.getStringExtra("nom1")
        val res = handler.showData(ss)
        if (res.moveToFirst()) {
            val nom:String = res.getString(2)
            val prenom:String = res.getString(1)
            tck_nom.setText(nom+" "+prenom) //Concaténation du nom & prénom du client dans une seule case
        }
    }

}

