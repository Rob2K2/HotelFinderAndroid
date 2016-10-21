package net.macaws.it.hotelfinderandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import net.macaws.it.hotelfinderandroid.adapter.HotelAdapter;
import net.macaws.it.hotelfinderandroid.model.Hotel;

import java.util.ArrayList;

public class Dashboard2Activity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        listView = (ListView)findViewById(R.id.list_view2);

        Intent i = getIntent();
        ArrayList<Hotel> parametero = (ArrayList<Hotel>) i.getSerializableExtra("hotels");

        HotelAdapter arrayAdapter = new HotelAdapter(this);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.addAll(parametero);
    }
}
