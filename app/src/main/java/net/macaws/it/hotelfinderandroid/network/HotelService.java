package net.macaws.it.hotelfinderandroid.network;

import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rob on 19/10/2016.
 */

public interface HotelService {

    @GET("hotels.php")
    Call<List<Hotel>> getHotels(@Query("city") String city);

    @GET("hotels.php")
    Call<List<Hotel>> getHotels();
}
