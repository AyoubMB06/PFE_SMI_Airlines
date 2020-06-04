package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AccueilApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil_app)

        var listview = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(Model("MON PROFIL","Cliquez ici pour visiter votre profil",R.drawable.logo_profil))
        list.add(Model("VOLS DISPONIBLES","Cliquez ici pour parcourir nos vols",R.drawable.list))
        list.add(Model("HISTORIQUE DES VOLS","Cliquez ici pour parcourir vos vols",R.drawable.myfly))
        list.add(Model("NOS PILOTES","Cliquez ici pour découvrir nos pilotes",R.drawable.pilotes1))
        list.add(Model("NOS AVIONS","Cliquez ici pour découvrir nos avions",R.drawable.flight))
        list.add(Model("SE DECONNECTER","Cliquez ici pour se déconnecter",R.drawable.logout1))

        listview.adapter = MyAdapter(this, R.layout.activity_accueil_app, list)

        listview.setOnItemClickListener {
                parent: AdapterView<*>, view: View, position: Int, id: Long ->
            if (position == 0){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var profil = Intent(this, ProfilApp::class.java)
                startActivity(profil)
            }
            if (position == 1){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var vols = Intent(this, Pilotes::class.java)
                startActivity(vols)
            }
            if (position == 2){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var accueil = Intent(this, AccueilApp::class.java)
                startActivity(accueil)
            }
            if (position == 3){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var pilotes = Intent(this, Avions::class.java)
                startActivity(pilotes)
            }
            if (position == 4){
                //Toast.makeText(this,"you click on 1",Toast.LENGTH_SHORT).show()
                var avions = Intent(this, Pilotes::class.java)
                startActivity(avions)
            }
            if (position == 5){
                Toast.makeText(this,"A bientôt",Toast.LENGTH_SHORT).show()
                var login = Intent(this, MainActivity::class.java)
                startActivity(login)
            }

        }

    }
    override fun onBackPressed(){

    }
}

