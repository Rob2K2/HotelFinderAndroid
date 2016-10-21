package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        Toast.makeText(this, "Location to look for: " + location, Toast.LENGTH_LONG).show();
        /*
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra("city", location);
        this.startActivity(intent);
        */
        SearchAsyncTask task = new SearchAsyncTask(this);
        task.execute(location);
    }
}
