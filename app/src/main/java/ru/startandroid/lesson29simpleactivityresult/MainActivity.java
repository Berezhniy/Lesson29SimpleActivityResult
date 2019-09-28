package ru.startandroid.lesson29simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvName;
    Button btnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //нахожу view по id
        tvName = findViewById(R.id.tvName);
        btnName = findViewById(R.id.btnName);
        //вешаю слушатель
        btnName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //создаю и инициализирую intent с данными о стартовой и конечной активити
        Intent intent = new Intent(this, Name.class);
        //запускаю активность по intent и ожидая результат по requestCode "1"
        startActivityForResult(intent,1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //если data ничего не хранит то ничего не происходит
        if (data == null) {
            return;
        }
        //Создаю переменную name типа String и кладу в неё данные из data
        String name = data.getStringExtra("name");
        //кладём во view заданный текст и данные из name
        tvName.setText("Your name is " + name);
    }
    }

