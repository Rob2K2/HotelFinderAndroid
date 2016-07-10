package net.macaws.it.hotelfinderandroid;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    private String title;
    private String content;
    private TextView titulo;
    private TextView contenido;
    //private image;
    private de.hdodenhof.circleimageview.CircleImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = getIntent().getExtras().getString("title");
        content = getIntent().getExtras().getString("content");
        //image = getIntent().getExtras().getString("image");

        titulo = (TextView) findViewById(R.id.txtTitle);
        contenido = (TextView) findViewById(R.id.txtContent);
        CircleImageView profileImageView = (CircleImageView) findViewById(R.id.profile_image_view);

        titulo.setText(title);
        contenido.setText(content);
        //Glide.with((profileImageView);
    }
}
