package com.example.molloisrael_camperodenilson_proyectofinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.molloisrael_camperodenilson_proyectofinal.Activity.IntroActivity;
import com.example.molloisrael_camperodenilson_proyectofinal.Activity.MainActivity;
import com.example.molloisrael_camperodenilson_proyectofinal.Activity.ShowDetailActivity;
import com.example.molloisrael_camperodenilson_proyectofinal.Activity.prueba;
import com.example.molloisrael_camperodenilson_proyectofinal.Domain.CategoryDomain;
import com.example.molloisrael_camperodenilson_proyectofinal.Domain.FoodDomain;
import com.example.molloisrael_camperodenilson_proyectofinal.R;

import java.util.ArrayList;

public class PoplurarAdaptor extends RecyclerView.Adapter<PoplurarAdaptor.ViewHolder> {
    ArrayList<FoodDomain> popularFood;

    public PoplurarAdaptor(ArrayList<FoodDomain> categoryDomains) {
        this.popularFood = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }

}
