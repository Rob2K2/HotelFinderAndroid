package net.macaws.it.hotelfinderandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.macaws.it.hotelfinderandroid.R;
import net.macaws.it.hotelfinderandroid.model.Hotel;


import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Rob on 19/10/2016.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    public HotelAdapter(Context context) {
        super(context, R.layout.hotel_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hotel hotel = getItem(position);
        View currentView;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.hotel_item_layout, parent, false);
        } else {
            currentView = convertView;
        }

        TextView nameTextView = (TextView)currentView.findViewById(R.id.hotel_title_text_view);
        TextView phoneTextView = (TextView)currentView.findViewById(R.id.hotel_phone_text_view);
        TextView addressTextView = (TextView)currentView.findViewById(R.id.hotel_address_text_view);
        TextView webTextView = (TextView)currentView.findViewById(R.id.hotel_web_text_view);
        TextView cityTextView = (TextView)currentView.findViewById(R.id.hotel_city_text_view);
        ImageView hotelImageView = (ImageView) currentView.findViewById(R.id.hotel_image_view);

        nameTextView.setText(hotel.getName());
        phoneTextView.setText(hotel.getPhone());
        addressTextView.setText(hotel.getAddress());
        webTextView.setText(hotel.getWeb());
        cityTextView.setText(hotel.getCity());

        Glide.with(getContext()).load(hotel.getUrlThumb()).into(hotelImageView);

        return currentView;
    }
}
