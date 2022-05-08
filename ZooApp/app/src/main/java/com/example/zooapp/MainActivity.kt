package com.example.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimals.add(Animal("Baboon","Baboon live in with place with tree", R.drawable.baboon))
        listOfAnimals.add(Animal("Bulldog","Bulldog live in with place with tree", R.drawable.bulldog))
        listOfAnimals.add(Animal("Panda","Panda live in with place with tree", R.drawable.panda))
        listOfAnimals.add(Animal("Swallow","Swallow live in with place with tree", R.drawable.swallow_bird))
        listOfAnimals.add(Animal("Tiger","Tiger live in with place with tree", R.drawable.white_tiger))
        listOfAnimals.add(Animal("Zebra","Zebra live in with place with tree", R.drawable.zebra))
        adapter=AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{

        var listOfAnimals = ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket,null)
            myView.tvDes.text=animal.name!!
            myView.tvDes.text=animal.des!!
            myView.ivAnimalImage.setImageResource(animal.image!!)
            return myView
        }
        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

    }

    }
