package net.macaws.it.hotelfinderandroid;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.macaws.it.hotelfinderandroid.model.Hotel;
import net.macaws.it.hotelfinderandroid.model.Post;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = (TextView)findViewById(R.id.txtTitle);
        TextView contentTextView = (TextView)findViewById(R.id.txtContent);
        //CircleImageView profileImageView = (CircleImageView) findViewById(R.id.profile_image_view);
        ImageView profileImageView = (ImageView) findViewById(R.id.profile_image_view);
        TextView addressTextView = (TextView)findViewById(R.id.txtAddress);
        TextView phoneTextView = (TextView)findViewById(R.id.txtPhone);
        TextView webTextView = (TextView)findViewById(R.id.txtWeb);
        TextView summaryTextView = (TextView)findViewById(R.id.txtSummary);

        Hotel hotel = (Hotel)(getIntent().getSerializableExtra("HOTEL"));
        if (hotel != null) {
            titleTextView.setText(hotel.getName());
            contentTextView.setText(hotel.getAddress());
            //Glide.with(this).load(hotel.getUrlImage()).into(profileImageView);
            Glide.with(this).load(hotel.getUrlImage()).into(profileImageView);
            addressTextView.setText(hotel.getAddress());
            phoneTextView.setText(hotel.getPhone());
            webTextView.setText(hotel.getWeb());
            summaryTextView.setText(hotel.getSummary());
        }
    }
}
