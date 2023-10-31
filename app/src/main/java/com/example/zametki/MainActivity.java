package com.example.zametki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public String[] NotesThemes = {"Тема 1","Тема 2","Тема 3","Тема 4","Тема 5",};
    public String[] NotesText = {"dsfsdfsdf 1","sfadfsdvsd 2","sdfsdfsdf 3","sdfsdfsdf 4","dsfsdfds 5",};

    public void SetData(int pos, String theme, String text){
        NotesThemes[pos] = theme;
        NotesText[pos] = text;
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        int pos = intent.getIntExtra("pos", 0);
                        String Theme = intent.getStringExtra("Theme");
                        String Text = intent.getStringExtra("Text");
                        Toast.makeText(MainActivity.this, Theme + " | " + Text, Toast.LENGTH_SHORT).show();
                        NotesThemes[pos] = Theme;
                        NotesText[pos] = Text;

                        //this.SetData(pos, Theme, Text);


                    }
                    else{

                    }
                }

            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, NotesThemes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, Note.class);
                intent.putExtra("Theme", NotesThemes[position]);
                intent.putExtra("Text", NotesText[position]);
                intent.putExtra("pos", position);
                mStartForResult.launch(intent);
                //startActivity(intent);
            }
        });
    }
}