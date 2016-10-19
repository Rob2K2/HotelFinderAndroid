package net.macaws.it.hotelfinderandroid.network;

import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rob on 19/10/2016.
 */

public interface HotelService {

    @GET("hotels.php")
    Call<List<Hotel>> getHotels();
}
