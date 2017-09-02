package com.teste.rodrigo.e_deploy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.teste.rodrigo.e_deploy.R;

public class PontuacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.txt_resultado));
    }
}
