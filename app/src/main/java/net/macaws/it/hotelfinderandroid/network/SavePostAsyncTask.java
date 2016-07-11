package net.macaws.it.hotelfinderandroid.network;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.DashboardActivity;
import net.macaws.it.hotelfinderandroid.LoginActivity;
import net.macaws.it.hotelfinderandroid.NewPostActivity;
import net.macaws.it.hotelfinderandroid.R;
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
    private NewPostActivity activity;

    public SavePostAsyncTask(NewPostActivity activity) {
        this.activity = activity;
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

    @Override
    protected void onPostExecute(Post post) {
        if (post == null) {
            Toast.makeText(activity ,"Save unsuccessful", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(activity,
                    "Save successful, post title: " + post.getTitle(),
                    Toast.LENGTH_LONG).show();
        }

    }
}
