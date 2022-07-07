package sg.edu.rp.c346.id20028056.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnSave, btnRestore;
    EditText etText;

    //are you able to see this


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnRestore = findViewById(R.id.btnRestore);
        etText = findViewById(R.id.etText);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedData = etText.getText().toString();

                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("value", savedData);
                prefEdit.commit();
            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                String loadedData = prefs.getString("value", "No greetings!");
                etText.setText(loadedData);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        String savedData = etText.getText().toString();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("value", savedData);
        prefEdit.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String loadedData = prefs.getString("value", "No greetings!");
        etText.setText(loadedData);

    }
}