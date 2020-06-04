package com.mb.appgestionvols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_avions.*
import kotlinx.android.synthetic.main.activity_admin_pilotes.*
import kotlinx.android.synthetic.main.activity_admin_pilotes.avionTxt
import kotlinx.android.synthetic.main.activity_admin_pilotes.deleteBtn
import kotlinx.android.synthetic.main.activity_admin_pilotes.idTxt
import kotlinx.android.synthetic.main.activity_admin_pilotes.insertBtn
import kotlinx.android.synthetic.main.activity_admin_pilotes.nameTxt
import kotlinx.android.synthetic.main.activity_admin_pilotes.updateBtn

class AdminPilotes : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_pilotes)

        handleInserts()
        handleUpdates()
        handleDeletes()

        //Affichage des messages correspondants à chaque action
        insertBtn.setOnClickListener{
            Toast.makeText(this,"Ajouté avec succés", Toast.LENGTH_SHORT).show()
        }
        updateBtn.setOnClickListener{
            Toast.makeText(this,"Modifié avec succés", Toast.LENGTH_SHORT).show()
        }
        deleteBtn.setOnClickListener{
            Toast.makeText(this,"Supprimé avec succés", Toast.LENGTH_SHORT).show()
        }
    }

    //Insertion des données dans la BD
    fun handleInserts() {
        insertBtn.setOnClickListener {
            dbHelper.insertPilote(
                idTxt.text.toString(),
                nameTxt.text.toString(),
                avionTxt.text.toString()
            )
        }
    }
    //Mise à jour de la table Pilotes dans la BD
    fun handleUpdates() {
        updateBtn.setOnClickListener {
                val isUpdate = dbHelper.insertPilote(
                    idTxt.text.toString(),
                    nameTxt.text.toString(),
                    avionTxt.text.toString()
                )
        }
    }
    //Suppression des données de la BD
    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData("Pilotes",idTxt.text.toString())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


}