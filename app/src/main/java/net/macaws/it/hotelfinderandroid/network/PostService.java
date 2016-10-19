package net.macaws.it.hotelfinderandroid.network;

import net.macaws.it.hotelfinderandroid.model.Post;
import net.macaws.it.hotelfinderandroid.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Rob on 10/07/2016.
 */
public interface PostService {
    @GET("posts?user_id=7")
    Call<List<Post>> getPosts();

   // @GET("hotels.php")
    //Call<List<Post>> getPosts();

    @POST("/posts?user_id=7")
    Call<Post> savePost(@Body Post post);
}
