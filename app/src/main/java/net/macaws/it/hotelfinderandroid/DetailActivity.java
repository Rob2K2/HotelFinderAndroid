package net.macaws.it.hotelfinderandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.macaws.it.hotelfinderandroid.model.Hotel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = (TextView)findViewById(R.id.txtTitle);
        ImageView profileImageView = (ImageView) findViewById(R.id.profile_image_view);
        TextView addressTextView = (TextView)findViewById(R.id.txtAddress);
        TextView phoneTextView = (TextView)findViewById(R.id.txtPhone);
        TextView webTextView = (TextView)findViewById(R.id.txtWeb);
        TextView summaryTextView = (TextView)findViewById(R.id.txtSummary);
        TextView roomsTextView = (TextView)findViewById(R.id.txtRooms);
        TextView singleTextView = (TextView)findViewById(R.id.txtSingle);
        TextView dobleTextView = (TextView)findViewById(R.id.txtDoble);
        Hotel hotel = (Hotel)(getIntent().getSerializableExtra("HOTEL"));
        if (hotel != null) {
            titleTextView.setText(hotel.getName());
            Glide.with(this).load(hotel.getUrlImage()).into(profileImageView);
            addressTextView.setText(hotel.getAddress());
            phoneTextView.setText(hotel.getPhone());
            webTextView.setText(hotel.getWeb());
            summaryTextView.setText(hotel.getSummary());
            roomsTextView.setText(hotel.getRooms());
            singleTextView.setText(hotel.getSingle());
            dobleTextView.setText(hotel.getDoble());
        }
    }
}
