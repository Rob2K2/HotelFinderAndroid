package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.adapter.HotelAdapter;
import net.macaws.it.hotelfinderandroid.data.prefs.SessionPrefs;
import net.macaws.it.hotelfinderandroid.model.Hotel;
import net.macaws.it.hotelfinderandroid.network.SearchMapAsyncTask;

import java.util.ArrayList;

public class Dashboard2Activity extends AppCompatActivity {
    public static final String PREFS_NAME = "HOTEL_FINDER_SEARCH_PREFS";
    public static final String PREF_SEARCH = "PREF_SEARCH";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        listView = (ListView) findViewById(R.id.list_view2);

        Intent i = getIntent();
        ArrayList<Hotel> parametero = (ArrayList<Hotel>) i.getSerializableExtra("hotels");

        final HotelAdapter arrayAdapter = new HotelAdapter(this);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.addAll(parametero);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hotel h = arrayAdapter.getItem(position);
                Toast.makeText(Dashboard2Activity.this, "Details for hotel: " + h.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard2Activity.this, DetailActivity.class);
                intent.putExtra("HOTEL", h);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_option:
                logout();
                return true;
            case R.id.profile_option:
                profile();
                return true;
            case R.id.maps_option:
                maps();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SessionPrefs.get(this).logOut();
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
        finish();
    }

    private void profile() {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void maps() {

        SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String location = myPrefs.getString(PREF_SEARCH, "");
        SearchMapAsyncTask task = new SearchMapAsyncTask(this);
        task.execute(location);
    }
}
