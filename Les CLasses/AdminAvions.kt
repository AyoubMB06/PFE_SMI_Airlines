package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_avions.*
import kotlinx.android.synthetic.main.activity_admin_avions.avionTxt
import kotlinx.android.synthetic.main.activity_admin_avions.deleteBtn
import kotlinx.android.synthetic.main.activity_admin_avions.idTxt
import kotlinx.android.synthetic.main.activity_admin_avions.insertBtn
import kotlinx.android.synthetic.main.activity_admin_avions.nameTxt
import kotlinx.android.synthetic.main.activity_admin_avions.updateBtn
import kotlinx.android.synthetic.main.activity_admin_pilotes.*
import kotlinx.android.synthetic.main.activity_contrat1.*


class AdminAvions : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_avions)

        handleInserts()
        handleUpdates()

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

    fun handleInserts() {
        insertBtn.setOnClickListener {
            dbHelper.insertAvion(
                idTxt.text.toString(),
                nameTxt.text.toString(),
                avionTxt.text.toString()
            )
        }
    }

    fun handleUpdates() {
        updateBtn.setOnClickListener {
            val isUpdate = dbHelper.insertAvion(
                idTxt.text.toString(),
                nameTxt.text.toString(),
                avionTxt.text.toString()
            )
        }
    }

    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData("Avions",idTxt.text.toString())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}