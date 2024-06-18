package com.example.molloisrael_camperodenilson_proyectofinal.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList=findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Carnes", "cat_1"));
        categoryList.add(new CategoryDomain("Lacteos", "cat_2"));
        categoryList.add(new CategoryDomain("Frutas", "cat_3"));
        categoryList.add(new CategoryDomain("Verduras", "cat_4"));
        categoryList.add(new CategoryDomain("Cereales", "cat_5"));


        adapter=new CategoryAdaptor(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }

    private void recycleViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recycleView2);

        ArrayList<FoodDomain> foodList = new ArrayList<>();

        foodList.add(new FoodDomain("Sandia", "pizza1", "¡Descubre la dulzura y la frescura de nuestras sandías! ", 39.99));
        foodList.add(new FoodDomain("Cereal de Quinoa", "burger","¡Eleva tus desayunos y meriendas con nuestro cereal de quinoa! Nutrición, sabor y bienestar en cada cucharada.", 9.99));
        foodList.add(new FoodDomain("Carne de Cerdo", "pizza2", "¡Agrega sabor y variedad a tus comidas con nuestra carne de cerdo de calidad premium! (X KILO)", 50.99));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}