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
        // получение объектов текста
        TextView EditText = findViewById(R.id.editText);
        TextView EditText2 = findViewById(R.id.editText2);
        // получение переданого интента
        Intent intent = getIntent();
        String Theme = intent.getStringExtra("Theme");
        String Text = intent.getStringExtra("Text");
        int pos = intent.getIntExtra("pos", 0);
        // получение объекта кнопки
        Button backButton = findViewById(R.id.backbutton);
        // слушаем ивент
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создание интента
                Intent data = new Intent();
                // всталвяем данные
                String ThemeSend = String.valueOf(EditText.getText());
                String TextSend = String.valueOf(EditText2.getText());
                data.putExtra("Theme", ThemeSend);
                data.putExtra("Text", TextSend);
                data.putExtra("pos", pos);
                // выставление результат
                setResult(RESULT_OK, data);
                // завершение работы активности
                finish();
            }
        });



        // выставляем получение данные
        EditText.setText(Theme);
        EditText2.setText(Text);

    }

}