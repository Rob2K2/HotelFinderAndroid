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

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPassword);
    }

    public void loginClick(View view) {

        Log.d("LoginActivity", "You clicked me!");
        Log.d("LoginActivity", "Username: " + username.getText());
        Log.d("LoginActivity", "Password: " + password.getText());
        String rightUsername = "admin";
        String rightPassword = "foobar";

        if (rightUsername.equals(username.getText().toString()) &&
                rightPassword.equals(password.getText().toString())) {
            Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
            // SharedPreferences hace referencia a un archivo
            // de configuracion
            SharedPreferences preferences =
                    getSharedPreferences(getString(R.string.app_name), // Nombre archivo
                            Context.MODE_PRIVATE); // Solo nuestra app puede leer esto
            SharedPreferences.Editor editor = preferences.edit(); // Abrir el archivo para escritura
            editor.putString("username", username.getText().toString()); // Almacenar el valor
            editor.commit(); // Guardar cambios

            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show();
        }
    }
}
