package net.macaws.it.hotelfinderandroid.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import net.macaws.it.hotelfinderandroid.data.api.model.User;

/**
 * Created by Rob on 12/02/2017.
 */
public class SessionPrefs {

    public static final String PREFS_NAME = "HOTEL_FINDER_PREFS";
    public static final String PREF_AFFILIATE_ID = "PREF_USER_ID";
    public static final String PREF_AFFILIATE_NAME = "PREF_AFFILIATE_NAME";
    public static final String PREF_AFFILIATE_ADDRESS = "PREF_AFFILIATE_ADDRESS";
    public static final String PREF_AFFILIATE_GENDER = "PREF_AFFILIATE_GENDER";
    public static final String PREF_AFFILIATE_TOKEN = "PREF_AFFILIATE_TOKEN";
    public static final String PREF_AFFILIATE_EMAIL = "PREF_AFFILIATE_EMAIL";

    private final SharedPreferences mPrefs;

    private boolean mIsLoggedIn = false;

    private static SessionPrefs INSTANCE;

    public static SessionPrefs get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SessionPrefs(context);
        }
        return INSTANCE;
    }

    private SessionPrefs(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        mIsLoggedIn = !TextUtils.isEmpty(mPrefs.getString(PREF_AFFILIATE_TOKEN, null));
    }

    public boolean isLoggedIn() {
        return mIsLoggedIn;
    }

    public void saveAffiliate(User affiliate) {
        if (affiliate != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_AFFILIATE_ID, affiliate.getId());
            editor.putString(PREF_AFFILIATE_NAME, affiliate.getName());
            editor.putString(PREF_AFFILIATE_ADDRESS, affiliate.getAddress());
            editor.putString(PREF_AFFILIATE_GENDER, affiliate.getGender());
            editor.putString(PREF_AFFILIATE_TOKEN, affiliate.getToken());
            editor.putString(PREF_AFFILIATE_EMAIL, affiliate.getEmail());
            editor.apply();

            mIsLoggedIn = true;
        }
    }

    public void logOut(){
        mIsLoggedIn = false;
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(PREF_AFFILIATE_ID, null);
        editor.putString(PREF_AFFILIATE_NAME, null);
        editor.putString(PREF_AFFILIATE_ADDRESS, null);
        editor.putString(PREF_AFFILIATE_GENDER, null);
        editor.putString(PREF_AFFILIATE_TOKEN, null);
        editor.putString(PREF_AFFILIATE_EMAIL, null);
        editor.apply();
    }
}
