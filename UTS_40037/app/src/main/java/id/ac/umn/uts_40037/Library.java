package id.ac.umn.uts_40037;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Library extends AppCompatActivity {
    private final ArrayList<Sfx> sfxList = new ArrayList<>();
    public static final String EXTRA_NAME = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        String username = getIntent().getStringExtra(EXTRA_NAME);
        Objects.requireNonNull(getSupportActionBar()).setTitle(username);

        Toast.makeText(this, "Selamat datang, " + username, Toast.LENGTH_SHORT).show();

        SfxList();

        SfxAdapter Adapter = new SfxAdapter(this, sfxList);
        RecyclerView rvLibraryList = findViewById(R.id.list_sfx);
        rvLibraryList.setAdapter(Adapter);
        rvLibraryList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setOption(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setOption(int selectedOption) {
        if (selectedOption == R.id.profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else {
            Intent mainIntent = new Intent(Library.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }

    private void SfxList() {
        sfxList.add(new Sfx("Bruh", "Meme", R.raw.bruh));
        sfxList.add(new Sfx("Nico Nico Nii", "Anime", R.raw.nico_nico_nii));
        sfxList.add(new Sfx("Tuturu", "Anime", R.raw.tuturu));
        sfxList.add(new Sfx("Windows XP", "Meme", R.raw.windows_xp));
    }
}