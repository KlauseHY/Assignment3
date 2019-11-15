package com.klaus.hometask3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.klaus.hometask3.fragment.FavouriteFragment;
import com.klaus.hometask3.fragment.HomeFragment;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CatActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView lableLife;
    private TextView labledog;
    private TextView label_temperament;
    private TextView label_description;
    private TextView label_origin;
    private TextView label_weight;
    private TextView label_wiki;
    private Cat cat;
    private TextView label_name;
    private ImageView ivFav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        lableLife =findViewById(R.id.label_life_span);
        labledog = findViewById(R.id.label_dog);
        label_temperament = findViewById(R.id.label_temperament);
        label_description = findViewById(R.id.label_description);
        label_origin = findViewById(R.id.label_origin);
        label_weight = findViewById(R.id.label_weight);
        label_wiki = findViewById(R.id.label_wiki);
        label_name = findViewById(R.id.label_name);
        imageView = findViewById(R.id.image);
        cat= (Cat) getIntent().getSerializableExtra("cat");

        label_description.setText(cat.getDescription());
        lableLife.setText(cat.getLife_span());
        label_wiki.setText(cat.getWikipedia_url());
        labledog.setText(cat.getDog_friendly());
        label_temperament.setText(cat.getTemperament());
        label_origin.setText(cat.getOrigin());
        label_name.setText(cat.getName());
        label_weight.setText(cat.getWeight().getMetric());
        ivFav = findViewById(R.id.iv_fav);
        ivFav .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavouriteFragment.addList(cat);
                Toast.makeText(CatActivity.this,"Successfully added",Toast.LENGTH_SHORT).show();
            }
        });
        getImage();
    }

    private void getImage() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        };
        Response.Listener<String> response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Image[] objectsArray = gson.fromJson(response, Image[].class);
                List<Image> images = Arrays.asList(objectsArray);
                String imageUrl = images.get(0).getUrl();
                Glide.with(CatActivity.this)
                        .load(imageUrl).into(imageView);
            }
        };

        StringRequest request = new StringRequest(Request.Method.GET,
                "https://api.thecatapi.com/v1/images/search?breed_id="+cat.getId(),
                response,error);

        requestQueue.add(request);
    }

    public void click(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
