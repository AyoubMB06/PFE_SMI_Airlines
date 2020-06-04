package com.mb.appgestionvols

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//La classe qui est responsable de la gestion de la base de données SQLite
class DatabaseHelper (context: Context):SQLiteOpenHelper(context,dbname,factory,version){

    //La méthode onCreate qui crée les différentes tables
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table client (noClient integer primary key autoincrement, " +
                "nomC varchar(30)," +
                "prénomC varchar(30)," +
                "emailC varchar(50)," +
                "mdpC varchar(30)," +
                "telC INTEGER)")
        db?.execSQL("create table avion (noAv integer primary key autoincrement, " +
                "typeA varchar(30)," +
                "paysA varchar(30)," +
                "annéeA integer(4))")
        db?.execSQL("create table pilote (noP integer primary key autoincrement, " +
                "nomP varchar(30)," +
                "villeP varchar(30)," +
                "noAv integer)")
        db?.execSQL("create table vol (noV integer primary key autoincrement, " +
                "depart varchar(30)," +
                "destination varchar(30)," +
                "dateD varchar(30)," +
                "dateA varchar(30)," +
                "prix float(5,2)," +
                "noAv integer)")

    }

    //La méthode onUpgrade qui actualise la base de données au cas où on veut changer qlq chose
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

            db?.execSQL("create table contrats (noContrat integer primary key autoincrement, " +
                    "numeroB varchar(30)," +
                    "depart varchar(30)," +
                    "arrivee varchar(30)," +
                    "dateDep varchar(50)," +
                    "prix INTEGER)")

            //Insertion des données contrats:
            db?.execSQL("INSERT INTO contrats (numeroB, depart, arrivee, dateDep, prix ) VALUES ('2020-100','MOSELLE','LORRAINE','20/05/20 12:00 PM',10000)")
            db?.execSQL("INSERT INTO contrats (numeroB, depart, arrivee, dateDep, prix ) VALUES ('2020-200','LORRAINE','MOSELLE','21/05/20 06:15 AM',9500)")
            db?.execSQL("INSERT INTO contrats (numeroB, depart, arrivee, dateDep, prix ) VALUES ('2020-300','SARRE','ALSACE','25/05/20 01:30 AM',7000)")
            db?.execSQL("INSERT INTO contrats (numeroB, depart, arrivee, dateDep, prix ) VALUES ('2020-400','ALSACE','MOSELLE','06/06/20 09:15 PM',12000)")

            onCreate(db)

    }

    //Fonction insertClient responsable d'insérer les données du client lors de l'inscription:
    fun insertClient(nomC: String, prénomC: String, emailC: String, mdpC: String, telC: Int){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nomC",nomC)
        values.put("prénomC",prénomC)
        values.put("emailC",emailC)
        values.put("mdpC",mdpC)
        values.put("telC",telC)

        db.insert("client",null,values)
        db.close()
    }
    //Fonction insertContrat responsable d'insérer les données des contrats:
    fun insertContrat(numeroB: String, depart: String, arrivee: String, dateDep: String, prix:Int){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("numeroB",numeroB)
        values.put("depart",depart)
        values.put("arrivee",arrivee)
        values.put("dateDep",dateDep)
        values.put("prix",prix)

        db.insert("contrats",null,values)
        db.close()
    }

    //Fonction insertAvion responsable d'insérer les données des avions pour l'administrateur:
    fun insertAvion(typeA: String, paysA: String, annéeA: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("typeA",typeA)
        values.put("paysA",paysA)
        values.put("annéeA",annéeA)

        db.insert("avion",null,values)
        db.close()

    }
    //Fonction insertPilote responsable d'insérer les données des pilotes pour l'administrateur:
    fun insertPilote(nomP: String, villeP: String, noAv: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("nomP",nomP)
        values.put("villeP",villeP)
        values.put("noAv",noAv)

        db.insert("pilte",null,values)
        db.close()
    }
    //Fonction insertVol responsable d'insérer les données des vols pour l'administrateur:
    fun insertVol(depart: String, destination: String, dateD: String, dateA: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("depart",depart)
        values.put("destination",destination)
        values.put("dateD",dateD)
        values.put("dateA",dateA)

        db.insert("vol",null,values)
        db.close()
    }

    fun deleteData(table: String, id : String) : Int {
        val db = this.writableDatabase
        return db.delete(table,"ID = ?", arrayOf(id))
    }

    //Fonction qui permet de vérifier si les informations entrées par le client sont valides ou non
    fun checkClient(inputC:String, mdpC: String):Boolean{
        val db=writableDatabase
        val query="select * from client where (emailC = '$inputC' OR telC = '$inputC') and mdpC = '$mdpC' "
        val cursor = db.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    //Les fontions qui permet de récuperer les infos du client sous forme de curseur
    fun showData(id:String):Cursor {
        val db = this.writableDatabase
        val res = db.rawQuery("SELECT * FROM client where (emailC='$id' OR telC='$id') ", null)
        return res
    }
    //Les fontions qui permet de récuperer les infos des vols sous forme de curseur
    fun showVols(id:String):Cursor {
        val db = this.writableDatabase
        val res1 = db.rawQuery("SELECT * FROM contrats where numeroB='$id'", null)
        return res1
    }
    //Les différents aspects de notre base de données
    companion object{
        internal val dbname  = "GestionVol"
        internal val factory = null
        internal val version = 2
    }
}