package com.mb.appgestionvols

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resources:Int, var items:List<Model>): ArrayAdapter<Model>(mCtx, resources, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //Adaptateur pour l'affichage des vols:
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val imageView:ImageView = view.findViewById(R.id.liste_image)
        val titleTextView:TextView = view.findViewById(R.id.listeTitre)
        val descriptionTextView:TextView = view.findViewById(R.id.listeDescription)

        //Définition des différents models:
        var mItem:Model = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable((mItem.img)))
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.description
        if(position %2 == 1){
            view.setBackgroundColor(Color.WHITE)
        }else{
            view.setBackgroundColor(Color.rgb(217, 217, 217))
        }
        return view
    }
}