package id.ac.umn.uts_40037;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Profile extends AppCompatActivity {
    private ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imv = findViewById(R.id.foto_profil);

        Glide.with(this)
                .load(R.drawable.profile_picture)
                .circleCrop()
                .into(imv);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}