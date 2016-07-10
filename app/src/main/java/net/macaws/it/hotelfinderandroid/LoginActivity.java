package net.macaws.it.hotelfinderandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.macaws.it.hotelfinderandroid.http.LoginAsyncTask;
import net.macaws.it.hotelfinderandroid.model.User;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = (EditText)findViewById(R.id.editUsername);
        passwordEditText = (EditText)findViewById(R.id.editPassword);
    }

    public void onLoginClick(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        //RequestUsersAsyncTask task = new RequestUsersAsyncTask();
        //task.execute();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        LoginAsyncTask task = new LoginAsyncTask(this);
        task.execute(user);
    }
}
