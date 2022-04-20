package com.example.myapp

import android.icu.text.Transliterator
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24, "Item $i"))
        }


        val apiInterface = ApiInterface.create().getMovies("4fd2bb4bb63b014764cb0122da179334")

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue(object : Callback<Movies>, CustomAdapter.ItemClickListener {
            override fun onResponse(call:Call<Movies>?, response:Response<Movies>?) {

                // This will pass the ArrayList to our Adapter
                val adapter = CustomAdapter(response?.body()?.results, this)

                //response?.body()?.results
                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter

//                if(response?.body() != null)
//                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<Movies>, t:Throwable) {
            }

            override fun onItemClick(position:Int) {
                Toast.makeText(this@MainActivity2, "click $position", Toast.LENGTH_SHORT).show()
            }
        })


    }
}