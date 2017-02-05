package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.adapter.HotelAdapter;
import net.macaws.it.hotelfinderandroid.model.Hotel;
import net.macaws.it.hotelfinderandroid.model.Post;

import java.util.ArrayList;

public class Dashboard2Activity extends AppCompatActivity {

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
                Toast.makeText(Dashboard2Activity.this, "Details for hotel: " + h.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Dashboard2Activity.this, DetailActivity.class);
                intent.putExtra("HOTEL", h);
                startActivity(intent);
            }
        });
    }
}
