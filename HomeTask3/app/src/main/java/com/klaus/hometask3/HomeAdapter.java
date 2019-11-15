package com.klaus.hometask3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Cat> catList;
    private Context context;

    public HomeAdapter(Context context, ArrayList<Cat> catList) {
        this.catList = catList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Cat breed = catList.get(position);
        String name = breed.getName();
        holder.catName.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CatActivity.class);
                intent.putExtra("cat",breed);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catName;

        public ViewHolder(View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.cat);


        }

    }
}