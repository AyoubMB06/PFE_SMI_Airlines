package com.mb.appgestionvols

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profil_app.*
import java.text.SimpleDateFormat
import java.util.*


class ProfilApp : AppCompatActivity() {

    //Appel d'une variable qui nous aidera à nous connecter à la base de données
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_app)
        handleViewing()
    }

    //Fonction qui nous permet d'appeler les informations du client depuis la base de données
    fun handleViewing() {
        val ss:String = intent.getStringExtra("profil_id") //Récupération de l'id
        //Appel de la date en cours
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date = simpleDateFormat.format(Date())

        val res = dbHelper.showData(ss) //Appel de la fonction showDara de la BD
        if (res.moveToFirst()) {
            //On récupère les données dans les variables au-dessous
            val nom:String = res.getString(2)
            val prenom:String = res.getString(1)
            val email:String = res.getString(3)
            val mobile:String = res.getString(5)
            //On fait rentrer les champs de la vue "activity_profil_app" contenant les infos de la BD
            profil_nom.setText(nom)
            profil_prénom.setText(prenom)
            profil_email.setText(email)
            profil_mobile.setText("0"+mobile)
            profil_date.setText(date)
        }
    }

}



