package net.macaws.it.hotelfinderandroid.network;

import android.content.Intent;
import android.os.AsyncTask;

import net.macaws.it.hotelfinderandroid.Dashboard2Activity;
import net.macaws.it.hotelfinderandroid.HotelFragment;
import net.macaws.it.hotelfinderandroid.SearchActivity;
import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 20/10/2016.
 */

public class SearchAsyncTask extends AsyncTask<String, Void, ArrayList<Hotel>> {

    private SearchActivity activity;

    public SearchAsyncTask(SearchActivity activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<Hotel> doInBackground(String... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.macaws.net/hf/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HotelService service = retrofit.create(HotelService.class);
        Call<ArrayList<Hotel>> call = service.getHotels(params[0]);

        try {
            Response<ArrayList<Hotel>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(ArrayList<Hotel> hotels) {

        Intent intent = new Intent(activity, Dashboard2Activity.class);
        intent.putExtra("hotels", hotels);
        activity.startActivity(intent);
    }
}
