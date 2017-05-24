package br.unb.miguel.recyclerviewexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Miguel on 24/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    // No class attributes because all of them could be turned into local variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;

        // Title of the action bar
        getSupportActionBar().setTitle("Example with animals");

        // Bind the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recycler_view);
        recyclerView.setHasFixedSize(true);

        // Set the layout manager
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        // Set the animal list
        ArrayList<Animal> animalArrayList = setAnimalList();

        // Set the adapter and show in the screen
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(animalArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private ArrayList<Animal> setAnimalList(){
        // Inicialize the list of animals
        ArrayList<Animal> animalArrayList = new ArrayList<Animal>();

        // Add the animals (you can add as many animals you want!)
        animalArrayList.add(new Animal("Lion", "The king of the jungle", R.drawable.lion));
        animalArrayList.add(new Animal("Tiger", "A very strong feline", R.drawable.tiger));
        animalArrayList.add(new Animal("Bear", "Cute and lazy", R.drawable.bear));
        animalArrayList.add(new Animal("Rhino", "Be careful with him", R.drawable.rhino));

        return  animalArrayList;
    }
}
