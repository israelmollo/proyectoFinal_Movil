package com.example.molloisrael_camperodenilson_proyectofinal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molloisrael_camperodenilson_proyectofinal.Adapter.CategoryAdaptor;
import com.example.molloisrael_camperodenilson_proyectofinal.Adapter.PoplurarAdaptor;
import com.example.molloisrael_camperodenilson_proyectofinal.Domain.CategoryDomain;
import com.example.molloisrael_camperodenilson_proyectofinal.Domain.FoodDomain;
import com.example.molloisrael_camperodenilson_proyectofinal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recycleViewPopular();

        ConstraintLayout startBtn = findViewById(R.id.btncarrito);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton= findViewById(R.id.cardBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class)) ;
            }
        });
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList=findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Carnes", "catcarne"));
        categoryList.add(new CategoryDomain("Lacteos", "catlacteo"));
        categoryList.add(new CategoryDomain("Frutas", "catfrutas"));
        categoryList.add(new CategoryDomain("Verduras", "catverduras"));
        categoryList.add(new CategoryDomain("Cereales", "catcereal"));


        adapter=new CategoryAdaptor(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }

    private void recycleViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recycleView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Sandia Cruceña", "sandia", "¡Descubre la dulzura y la frescura de nuestras sandías! (GRANDE) ", 30.99));
        foodList.add(new FoodDomain("Cereal de Quinoa", "cereal_quinoa","¡Eleva tus desayunos y meriendas con nuestro cereal de quinoa! Nutrición, sabor y bienestar en cada cucharada.", 9.99));
        foodList.add(new FoodDomain("Carne de Cerdo", "carne_cerdo", "¡Agrega sabor y variedad a tus comidas con nuestra carne de cerdo de calidad premium! (X KILO)", 50.99));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}