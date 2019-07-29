package com.mockup.allexamples.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mockup.allexamples.Interfaces.JsonPleceHolderAPI;
import com.mockup.allexamples.R;
import com.mockup.allexamples.models.retrofitR.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends AppCompatActivity {

    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        mJsonTxtView = (TextView)findViewById(R.id.jsonText);
        getPosts();
    }

    private void getPosts(){
retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

        JsonPleceHolderAPI jsonPleceHolderAPI = retrofit.create(JsonPleceHolderAPI.class);

        Call<List<Posts>> call = jsonPleceHolderAPI.getPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Código " + response.code());
                    return;
                }

                List<Posts> postsList = response.body();

                for(Posts post: postsList){
                    String content = "";
                    content += "UserId: " + post.getUserId() + "\n";
                    content += "Id: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Body: " + post.getBody() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
