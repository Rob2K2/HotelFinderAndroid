package net.macaws.it.hotelfinderandroid.network;

import android.os.AsyncTask;

import net.macaws.it.hotelfinderandroid.PostFragment;
import net.macaws.it.hotelfinderandroid.model.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 10/07/2016.
 */
public class RetrievePostsAsyncTask extends AsyncTask<Void, Void, List<Post>> {
    private PostFragment fragment;

    public RetrievePostsAsyncTask(PostFragment postFragment) {
        this.fragment = postFragment;
    }

    @Override
    protected List<Post> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://www.macaws.net/hf/json/")
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService service = retrofit.create(PostService.class);
        Call<List<Post>> call = service.getPosts();

        try {
            Response<List<Post>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(posts);
    }
}