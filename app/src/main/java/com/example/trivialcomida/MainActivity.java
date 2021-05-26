package com.example.trivialcomida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        //1o Prato
        mImageUrls.add("https://craftlog.com/m/i/8459382=s1280=h960");
        mName.add("Bife à Parmemegiana");
        mDescription.add("Bife à parmegiana, com arroz e fritas");
        //2o Prato
        mImageUrls.add("https://www.receiteria.com.br/wp-content/uploads/receitas-de-salada-de-frango-1-730x449.jpg");
        mName.add("Salada");
        mDescription.add("Salada completa com pepino e cebola");
        //3o Prato
        mImageUrls.add("https://conteudo.imguol.com.br/c/entretenimento/29/2020/05/26/sopa-de-feijao-com-macarrao-1590515359013_v2_1440x960.jpg");
        mName.add("Sopa");
        mDescription.add("Sopa de legumes e molho de tomate");
        //4o Prato
        mImageUrls.add("https://static8.depositphotos.com/1004373/1070/i/600/depositphotos_10704665-stock-photo-grilled-steak.jpg");
        mName.add("Bife c/ fritas");
        mDescription.add("Bife de contra filé acompanhado de deliciosas fritas");
        //5o Prato
        mImageUrls.add("https://s2.glbimg.com/bd07NR6s44Un1FyZtTApismeLSs=/top/e.glbimg.com/og/ed/f/original/2021/04/23/feijoada_4.jpg");
        mName.add("Feijoada");
        mDescription.add("Uma deliciosa Feijoada");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");

        RecyclerView recyclerview = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageUrls, mName, mDescription);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}