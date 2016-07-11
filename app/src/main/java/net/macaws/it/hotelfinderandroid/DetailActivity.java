package net.macaws.it.hotelfinderandroid;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.macaws.it.hotelfinderandroid.model.Post;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = (TextView)findViewById(R.id.txtTitle);
        TextView contentTextView = (TextView)findViewById(R.id.txtContent);
        CircleImageView profileImageView = (CircleImageView) findViewById(R.id.profile_image_view);

        Post post = (Post)(getIntent().getSerializableExtra("POST"));
        if (post != null) {
            titleTextView.setText(post.getTitle());
            contentTextView.setText(post.getContent());
            Glide.with(this).load(post.getUser().getPicture_url()).into(profileImageView);

        }
    }
}
