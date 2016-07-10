package net.macaws.it.hotelfinderandroid.network;

import net.macaws.it.hotelfinderandroid.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rob on 10/07/2016.
 */
public interface PostService {
    @GET("posts?user_id=1")
    Call<List<Post>> getPosts();
}
