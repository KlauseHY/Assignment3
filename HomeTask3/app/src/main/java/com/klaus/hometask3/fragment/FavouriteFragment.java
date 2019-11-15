package com.klaus.hometask3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.klaus.hometask3.Cat;
import com.klaus.hometask3.HomeAdapter;
import com.klaus.hometask3.R;

import java.util.ArrayList;

public class FavouriteFragment extends Fragment {
    private View rootView;


    private RecyclerView listView;
    private HomeAdapter adapter;
    private static  ArrayList<Cat> favList = new ArrayList<>();
    private ArrayList<Cat> list = new ArrayList<>();


    public static FavouriteFragment newInstance(){

        return  new FavouriteFragment();

    }
    public static void addList(Cat cat){
        favList.add(cat);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_favourite,container,false);
        listView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(manager);
        adapter = new HomeAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        list.clear();
        list.addAll(favList);
        adapter.notifyDataSetChanged();

    }

    public void change(ArrayList<Cat> cats) {

    }
}
