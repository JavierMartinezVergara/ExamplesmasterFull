package com.mockup.allexamples.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.mockup.allexamples.Interfaces.JsonPleceHolderAPI;
import com.mockup.allexamples.R;
import com.mockup.allexamples.models.retrofitR.Posts;
import com.mockup.allexamples.models.retrofitR.PostsData;
import com.mockup.allexamples.Adapter.MyAdapterPosts;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    ArrayList<PostsData> postsData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        myRecyclerView = findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        getPosts();
    }

    private void getPosts(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPleceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPleceHolderAPI.class);
        Call<List<Posts>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                myAdapter = new MyAdapterPosts(postsData);
                myRecyclerView.setAdapter(myAdapter);

                List<Posts> rowsets = response.body();
                if (response.code() == 200) {

                    for(int i =0; i<rowsets.size();i++){
                        int int_id = rowsets.get(i).getId();
                        String id = String.valueOf(int_id);
                        String title = rowsets.get(i).getTitle();
                        String body = rowsets.get(i).getBody();

                        postsData.add(new PostsData(R.drawable.ic_comment, id, title, body));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }
}
