package com.example.apiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<Post>> {

    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create(gson)).build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<List<Post>> call = gerritAPI.loadPosts();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        if(response.isSuccessful())
        {
            List<Post> listPost = response.body();
            PostAdapter postAdapter = new PostAdapter(listPost,this);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
            recyclerView.setAdapter(postAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        else
        {
            Log.d("Response Error", String.valueOf(response.errorBody()));
        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {
        t.printStackTrace();
    }
}