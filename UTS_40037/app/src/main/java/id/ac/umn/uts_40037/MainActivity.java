package id.ac.umn.uts_40037;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnProfile;
    private Button btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnProfile = findViewById(R.id.profile_button_main);
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        });

        btnLibrary = findViewById((R.id.library_button_main));
        btnLibrary.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormInput.class);
            startActivity(intent);
        });
    }
}