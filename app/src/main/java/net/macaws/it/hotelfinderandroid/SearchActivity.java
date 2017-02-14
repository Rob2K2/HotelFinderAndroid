package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.data.prefs.SearchPrefs;
import net.macaws.it.hotelfinderandroid.data.prefs.SessionPrefs;
import net.macaws.it.hotelfinderandroid.network.SearchAsyncTask;

public class SearchActivity extends AppCompatActivity {

    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText) findViewById(R.id.search_edit_text);
    }

    public void onSearchClick(View view) {

        String location = searchEditText.getText().toString();

        Toast.makeText(this, "Location to look for: " + location, Toast.LENGTH_SHORT).show();

        // Guardar afiliado en preferencias
        SearchPrefs.get(SearchActivity.this).saveSearch(location);

        SearchAsyncTask task = new SearchAsyncTask(this);
        task.execute(location);
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
}
