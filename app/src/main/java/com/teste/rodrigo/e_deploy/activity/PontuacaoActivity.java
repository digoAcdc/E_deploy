package com.teste.rodrigo.e_deploy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.teste.rodrigo.e_deploy.Constants.Constants;
import com.teste.rodrigo.e_deploy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PontuacaoActivity extends AppCompatActivity {

    @BindView(R.id.tvPontuacao)
    protected TextView tvPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.txt_resultado));


        Intent i = getIntent();
        String cidade = i.getStringExtra(Constants.KEY_CIDADE);
        String pontuacao = i.getStringExtra(Constants.KEY_PONTUACAO);

        tvPontuacao.setText(getResources().getString(R.string.label_pontuacao, cidade, pontuacao));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
