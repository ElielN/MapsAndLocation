package com.example.mapsandlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String local = "Nenhum";
    boolean changeActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  button_CdNatal = (Button) findViewById(R.id.button_CdNatal);
        Button  button_Vicosa = (Button) findViewById(R.id.button_Vicosa);
        Button  button_Departamento = (Button) findViewById(R.id.button_Departamento);
        Button  button_Fechar = (Button) findViewById(R.id.button_Fechar);

        Intent it = new Intent(getBaseContext(), SecondActivity.class);
        Bundle params = new Bundle();


        button_CdNatal.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                params.putString("localizacao", "Cidade Natal");
                it.putExtras(params);
                startActivity(it);
            }
        });
        button_Vicosa.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                params.putString("localizacao", "Vicosa");
                it.putExtras(params);
                startActivity(it);
            }
        });
        button_Departamento.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                params.putString("localizacao", "Departamento");
                it.putExtras(params);
                startActivity(it);
            }
        });
        button_Fechar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}