package com.example.molloisrael_camperodenilson_proyectofinal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molloisrael_camperodenilson_proyectofinal.Adapter.CartListAdapter;
import com.example.molloisrael_camperodenilson_proyectofinal.Helper.ManagementCart;
import com.example.molloisrael_camperodenilson_proyectofinal.Interface.ChangeNumberItemsListener;
import com.example.molloisrael_camperodenilson_proyectofinal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CartListActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerViewList;
private ManagementCart managementCart;
TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
private double tax;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);
        initView();
        initList();
        CalculateCart();

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
                startActivity(new Intent(CartListActivity.this, CartListActivity.class)) ;
            }
        });
    }
    private void initView() {
        totalFeeTxt = findViewById(R.id.itemsTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);
        recyclerViewList = findViewById(R.id.cartView);
    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();

                recyclerViewList.setAdapter(adapter);
                if(managementCart.getListCart().isEmpty()){
                    emptyTxt.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                }else{
                    emptyTxt.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void CalculateCart(){
        double percentTax=0.02;
        double delivery = 10;

        tax=Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double  itemTotal = Math.round((managementCart.getTotalFee()*100))/100;

        totalFeeTxt.setText("Bs."+itemTotal);
        taxTxt.setText("Bs."+tax);
        deliveryTxt.setText("Bs."+delivery);
        totalTxt.setText("Bs." + total);

    }

}