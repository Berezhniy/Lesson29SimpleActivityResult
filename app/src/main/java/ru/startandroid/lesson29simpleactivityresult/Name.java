package ru.startandroid.lesson29simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        //нахожу view по id
        etName = findViewById(R.id.etName);
        btnOk = findViewById(R.id.btnOK);
        //вешаю слушатель
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Создаю и инициализирую intent
        Intent intent = new Intent();
        //кладу в intent данные из etName
        intent.putExtra("name", etName.getText().toString());
        //возвращаю результат
        setResult(RESULT_OK, intent);
        finish();
    }
}
