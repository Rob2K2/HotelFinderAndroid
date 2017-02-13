package net.macaws.it.hotelfinderandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.data.prefs.SessionPrefs;

public class ProfileActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "HOTEL_FINDER_PREFS";
    public static final String PREF_AFFILIATE_NAME = "PREF_AFFILIATE_NAME";
    public static final String PREF_AFFILIATE_EMAIL = "PREF_AFFILIATE_EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name = myPrefs.getString(PREF_AFFILIATE_NAME, "");
        String email = myPrefs.getString(PREF_AFFILIATE_EMAIL, "");

        TextView nameTextView = (TextView) findViewById(R.id.txtNameP);
        TextView emailTextView = (TextView) findViewById(R.id.txtEmailP);

        nameTextView.setText(name);
        emailTextView.setText(email);
    }

    public void onChangePasswordClick(View view) {
        Toast.makeText(this, "Not Available Yet" , Toast.LENGTH_SHORT).show();
    }
}
