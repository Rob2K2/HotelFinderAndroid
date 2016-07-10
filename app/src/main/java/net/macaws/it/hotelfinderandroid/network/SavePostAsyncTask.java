package net.macaws.it.hotelfinderandroid.network;

import android.os.AsyncTask;

import net.macaws.it.hotelfinderandroid.model.Post;
import net.macaws.it.hotelfinderandroid.model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 10/07/2016.
 */
public class SavePostAsyncTask extends AsyncTask<Post, Void, Post> {
    public SavePostAsyncTask() {
    }

    @Override

    protected Post doInBackground(Post... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<Post> call = service.savePost(params[0]);
        try {
            Response<Post> response = call.execute();
            Post post = response.body();

            return post;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
