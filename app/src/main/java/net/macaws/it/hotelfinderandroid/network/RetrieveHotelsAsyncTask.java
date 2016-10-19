package net.macaws.it.hotelfinderandroid.network;

import android.os.AsyncTask;

import net.macaws.it.hotelfinderandroid.HotelFragment;
import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 19/10/2016.
 */

public class RetrieveHotelsAsyncTask extends AsyncTask<Void, Void, List<Hotel>>{

    private HotelFragment fragment;

    public RetrieveHotelsAsyncTask(HotelFragment hotelFragment) {
        this.fragment = hotelFragment;
    }

    @Override
    protected List<Hotel> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.macaws.net/hf/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HotelService service = retrofit.create(HotelService.class);
        Call<List<Hotel>> call = service.getHotels();

        try {
            Response<List<Hotel>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<Hotel> hotels) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(hotels);
    }
}
