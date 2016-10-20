package net.macaws.it.hotelfinderandroid.network;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.DashboardActivity;
import net.macaws.it.hotelfinderandroid.LoginActivity;
import net.macaws.it.hotelfinderandroid.R;
import net.macaws.it.hotelfinderandroid.SearchActivity;
import net.macaws.it.hotelfinderandroid.model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rob on 09/07/2016.
 */
public class LoginAsyncTask extends AsyncTask<User, Void, User> {
    private LoginActivity activity;

    public LoginAsyncTask(LoginActivity activity) {
        this.activity = activity;
    }

    @Override
    protected User doInBackground(User... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.login(params[0]);
        try {
            Response<User> response = call.execute();
            User user = response.body();

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user == null) {
            // Codigo de error
            Toast.makeText(activity, "Login unsuccessful", Toast.LENGTH_LONG).show();
        } else {
            // Guardar al usuario en las preferencias
            SharedPreferences sharedPreferences = activity.getSharedPreferences(
                    activity.getString(R.string.app_name),
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id", user.getId());
            editor.commit();
            Toast.makeText(activity,
                    "Login successful, username: " + user.getUsername(),
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(activity, SearchActivity.class);
            //intent.putExtra("nombre", user.getUsername());
            activity.startActivity(intent);
        }
    }
}
