package com.design.capstone.icteducationbd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    ArrayList<Model> modelArrayList;
    private CategoryRecyclerAdapter foodItemRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        modelArrayList = new ArrayList<>();


        modelArrayList.add(new Model("Home" , R.drawable.home));
        modelArrayList.add(new Model("Register" , R.drawable.register));
        modelArrayList.add(new Model("Login" , R.drawable.login));
        modelArrayList.add(new Model("Exit" , R.drawable.exit));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_food);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);


        foodItemRecyclerAdapter = new CategoryRecyclerAdapter(this, modelArrayList);
        recyclerView.setAdapter(foodItemRecyclerAdapter);





    }

}
