package id.ac.umn.uts_40037;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SfxDetails extends AppCompatActivity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfx_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Sfx sfx = (Sfx) bundle.getSerializable("DetailSFX");

        Objects.requireNonNull(getSupportActionBar()).setTitle(sfx.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = MediaPlayer.create(this, sfx.getUri());

        TextView tvTitle = findViewById(R.id.detail_nama_sfx);
        TextView tvCategory = findViewById(R.id.detail_kategori_sfx);
        Button btnPlay = findViewById(R.id.detail_button_sfx);

        tvTitle.setText(sfx.getTitle());
        tvCategory.setText(sfx.getCategory());
        btnPlay.setOnClickListener(v -> mp.start());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
        mp.release();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
