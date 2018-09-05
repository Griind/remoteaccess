package svitukha.remoteaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText login = findViewById(R.id.loginId);
        EditText password = findViewById(R.id.passwordId);
        if (!login.getText().toString().equals("admin") && !password.getText().toString().equals("password")) {
            startActivity(new Intent(MainActivity.this, OnOfActivity.class));


        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Login or password is incorrect", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
            toast.show();

        }
    }
}
