package net.macaws.it.hotelfinderandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import net.macaws.it.hotelfinderandroid.model.Post;
import net.macaws.it.hotelfinderandroid.model.User;
import net.macaws.it.hotelfinderandroid.network.LoginAsyncTask;
import net.macaws.it.hotelfinderandroid.network.SavePostAsyncTask;

public class NewPostActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        titleEditText = (EditText)findViewById(R.id.editTitle);
        contentEditText = (EditText)findViewById(R.id.editContent);
    }

    public void onSaveClick(View view) {
        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        SavePostAsyncTask task = new SavePostAsyncTask(this);
        task.execute(post);
        finish();
    }
}
