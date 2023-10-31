package com.example.zametki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);
        TextView EditText = findViewById(R.id.editText);
        TextView EditText2 = findViewById(R.id.editText2);
        Intent intent = getIntent();
        String Theme = intent.getStringExtra("Theme");
        String Text = intent.getStringExtra("Text");
        int pos = intent.getIntExtra("pos", 0);
        Button backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                data.putExtra("Theme", EditText.getText());
                data.putExtra("Text", EditText2.getText());
                data.putExtra("pos", pos);
                Toast.makeText(Note.this, EditText.getText() + " | " + EditText2.getText(), Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, data);
                finish();
            }
        });




        EditText.setText(Theme);
        EditText2.setText(Text);

    }

}