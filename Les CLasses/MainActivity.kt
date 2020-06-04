package com.mb.appgestionvols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.register.*
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    //appel de l'objet qui nous aise à manipule notre base de données avec 'lateinit" qui veut dire qu'on va l'initaliser après
    lateinit var handler: DatabaseHelper
    //Définition de la fonction onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Appel à la vue 'activity_main.xml'
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        afficherLogin()

        //Définition des boutons login_register & register_login ect.. lors du clic
        login_resgister.setOnClickListener{
            afficherInscription()
        }
        register_login.setOnClickListener{
            afficherLogin()
        }
        //Lorsqu'on clique sur le bouton d'inscription:
        buRegister.setOnClickListener {
            if (validate()) {
                //Insertion des données du client à la base de données dans la table 'client' avec la fonction 'insertClient'
                handler.insertClient(
                    nomC.text.toString(),
                    prénomC.text.toString(),
                    emailC.text.toString(),
                    mdpC.text.toString(),
                    telC.text.toString().toInt()
                )
                afficherLogin()
            }
        }
        //Lorsqu'on clique sur le bouton d'authentification:
        buLogin.setOnClickListener{
            //Redirection en cas d'administrateur
            if(login_email.text.toString() == "admin" && login_mdp.text.toString() == "admin" ){
                var admin = Intent(this, AccueilAdmin::class.java)
                startActivity(admin)
            }
            else{
                if(validate1()){
                    //On vérifie les données avec ceux de la base de données avec la fonction checkClient
                    if(handler.checkClient(login_email.text.toString(), login_mdp.text.toString())) {
                        //Si on a validé le login, on redirectionne le client vers la page d'accueil avec 'INTENT' en lui passant une clé 'login' contenant les id entrés
                        var accueil = Intent(this, Accueil::class.java)
                        accueil.putExtra("login",login_email.text.toString())
                        startActivity(accueil)
                    }
                    else
                        //Dans la cas d'échec, on affiche un message TOAST court:
                        Toast.makeText(this,"Email ou mot de passe incorrect",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    //Ici on joue avec la visibilité des vues: on a LOGIN et INSCRIPTION: si on veut s'inscrire on affiche une et l'autre sinon
    private fun afficherInscription(){
        Register_layout.visibility = View.VISIBLE
        MainAll.visibility = View.GONE
    }
    private fun afficherLogin(){
        Register_layout.visibility = View.GONE
        MainAll.visibility = View.VISIBLE
    }

    //Les fonctions de control des paramêtres entrés aux champs
    private fun validate():Boolean{
        if(nomC.text.toString().trim().isEmpty()){
            nomC.error = "Veuillez entrer le nom"
            return false
        }
        if(prénomC.text.toString().trim().isEmpty()){
            prénomC.error = "Veuillez entrer le prénom"
            return false
        }
        if(emailC.text.toString().trim().isEmpty()){
            emailC.error = "Veuillez entrer l'e-mail"
            return false
        }
        if(mdpC.text.toString().trim().isEmpty()){
            mdpC.error = "Veuillez entrer le mot de passe"
            return false
        }
        if(mdpCC.text.toString().trim().isEmpty()){
            mdpCC.error = "Veuillez rentrer le mot de passe"
            return false
        }
        if(telC.text.toString().trim().isEmpty()){
            telC.error = "Veuillez entrer le numéro de téléphone"
            return false
        }
        if(!isValidEmail(emailC.text.toString().trim())){
            emailC.error = "Veuillez entrer un email valide"
            return false
        }
        if(mdpC.text.toString().trim().count()<8){
            mdpC.error = "Veuillez entrer au moins 8 caractères"
            return false
        }
        if(mdpCC.text.toString().trim().count()<8){
            mdpCC.error = "Veuillez entrer au moins 8 caractères"
            return false
        }
        if(mdpC.text.toString().trim() != mdpCC.text.toString().trim() ){
            mdpCC.error = "Veuillez entrer deux mots de passe identiques"
            return false
        }
        if(telC.text.toString().trim().count()!=10 ){
            telC.error = "Veuillez entrer un numéro de téléphone valide: 06XX"
            return false
        }
        return true
    }

    //Fonction de validation des champs LOGIN
    private fun validate1():Boolean{
        if(login_email.text.toString().trim().isEmpty()){
            login_email.error = "Veuillez entrer l'e-mail ou le numéro de téléphone"
            return false
        }
        if(login_mdp.text.toString().trim().isEmpty()){
            login_mdp.error = "Veuillez entrer le mot de passe"
            return false
        }
        if(login_mdp.text.toString().trim().count()<8){
            login_mdp.error = "Veuillez entrer un mot de passe avec au moins 8 caractères"
            return false
        }
        return true
    }

    //On élimine la fonction du bouton retour
    override fun onBackPressed() {

    }

    //Fonction qui valide l'email entré lors de l'inscription
    private fun isValidEmail(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }


}