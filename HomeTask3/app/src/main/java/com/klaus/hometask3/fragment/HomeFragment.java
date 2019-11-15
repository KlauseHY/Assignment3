package com.klaus.hometask3.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.klaus.hometask3.Cat;
import com.klaus.hometask3.HomeAdapter;
import com.klaus.hometask3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private View rootView;
    private EditText content;

    private ArrayList<Cat> catList;
    private RecyclerView listView;
    private HomeAdapter adapter;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home,container,false);
        content = (EditText) rootView.findViewById(R.id.content);
        listView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(manager);
        catList = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(),catList);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button searchButton = rootView.findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCats();
            }
        });
    }

    private void requestCats() {
        String name = content.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        };
        Response.Listener<String> response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Cat[] objectsArray = gson.fromJson(response, Cat[].class);
                List<Cat> list = Arrays.asList(objectsArray);
                catList.clear();
                catList.addAll(list);
                adapter.notifyDataSetChanged();
            }
        };

        StringRequest request = new StringRequest(Request.Method.GET,
                "https://api.thecatapi.com/v1/breeds/search?q="+name,
                response,error);

        requestQueue.add(request);
    }


}
