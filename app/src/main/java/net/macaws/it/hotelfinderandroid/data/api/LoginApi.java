package net.macaws.it.hotelfinderandroid.data.api;

import net.macaws.it.hotelfinderandroid.data.api.model.LoginBody;
import net.macaws.it.hotelfinderandroid.data.api.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rob on 12/02/2017.
 */

public interface LoginApi {

    // TODO: Cambiar host por "10.0.3.2" para Genymotion.
    // TODO: Cambiar host por "10.0.2.2" para AVD.
    // TODO: Cambiar host por IP de tu PC para dispositivo real.
    public static final String BASE_URL = "http://nethackerx.quimerasoft.com/v1/";

    @POST("affiliates/login")
    Call<User> login(@Body LoginBody loginBody);

}
