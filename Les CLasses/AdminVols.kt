package com.mb.appgestionvols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_avions.*
import kotlinx.android.synthetic.main.activity_admin_pilotes.*
import kotlinx.android.synthetic.main.activity_admin_vols.*
import kotlinx.android.synthetic.main.activity_admin_vols.deleteBtn
import kotlinx.android.synthetic.main.activity_admin_vols.idTxt
import kotlinx.android.synthetic.main.activity_admin_vols.insertBtn
import kotlinx.android.synthetic.main.activity_admin_vols.nameTxt
import kotlinx.android.synthetic.main.activity_admin_vols.updateBtn


class AdminVols : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_vols)

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
            dbHelper.insertVol(
                idTxt.text.toString(),
                nameTxt.text.toString(),
                prixtxt.text.toString(),
                datetxt.text.toString()
            )
        }
    }

    fun handleUpdates() {
        updateBtn.setOnClickListener {
            val isUpdate = dbHelper.insertVol(
                idTxt.text.toString(),
                nameTxt.text.toString(),
                prixtxt.text.toString(),
                datetxt.text.toString()
            )
        }
    }

    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData("Vols",idTxt.text.toString())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}