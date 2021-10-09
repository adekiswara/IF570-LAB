package id.ac.umn.uts_40037;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class FormInput extends AppCompatActivity {
    private EditText etInput;
    private Button btnNext;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        etInput = findViewById(R.id.hint_form_input);
//        etInput.setOnClickListener(v -> {
//            username = etInput.getText().toString();
//        });

        btnNext = findViewById(R.id.button_form_input);
        btnNext.setOnClickListener(v -> {
            username = etInput.getText().toString();

            if (username.trim().isEmpty()) {
                etInput.setError("Harap Di-isi");
                etInput.requestFocus();
            } else {
                Intent libraryIntent = new Intent(this, Library.class);
                libraryIntent.putExtra(Library.EXTRA_NAME, username);

                startActivity(libraryIntent);
            }
        });
    }
}