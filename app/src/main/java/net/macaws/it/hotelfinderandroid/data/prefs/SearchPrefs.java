package net.macaws.it.hotelfinderandroid.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import net.macaws.it.hotelfinderandroid.data.api.model.User;

/**
 * Created by Rob on 14/02/2017.
 */

public class SearchPrefs {

    public static final String PREFS_NAME = "HOTEL_FINDER_SEARCH_PREFS";
    public static final String PREF_SEARCH = "PREF_SEARCH";

    private final SharedPreferences mPrefs;

    //private boolean mIsLoggedIn = false;

    private static SearchPrefs INSTANCE;

    public static SearchPrefs get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SearchPrefs(context);
        }
        return INSTANCE;
    }

    private SearchPrefs(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        //mIsLoggedIn = !TextUtils.isEmpty(mPrefs.getString(PREF_AFFILIATE_TOKEN, null));
    }

   /* public boolean isLoggedIn() {
        return mIsLoggedIn;
    }*/

    public void saveSearch(String location) {
        if (location != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_SEARCH, location);
            editor.apply();
            //mIsLoggedIn = true;
        }
    }

    /*public void logOut(){
        mIsLoggedIn = false;
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(PREF_AFFILIATE_ID, null);
        editor.putString(PREF_AFFILIATE_NAME, null);
        editor.putString(PREF_AFFILIATE_ADDRESS, null);
        editor.putString(PREF_AFFILIATE_GENDER, null);
        editor.putString(PREF_AFFILIATE_TOKEN, null);
        editor.putString(PREF_AFFILIATE_EMAIL, null);
        editor.apply();
    }*/
}
