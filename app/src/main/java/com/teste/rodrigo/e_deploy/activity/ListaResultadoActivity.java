package com.teste.rodrigo.e_deploy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.teste.rodrigo.e_deploy.Constants.Constants;
import com.teste.rodrigo.e_deploy.R;
import com.teste.rodrigo.e_deploy.adapter.ResultadoAdapter;
import com.teste.rodrigo.e_deploy.api.ApiService;
import com.teste.rodrigo.e_deploy.api.IApiService;
import com.teste.rodrigo.e_deploy.model.State;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListaResultadoActivity extends AppCompatActivity {

    @BindView(R.id.rvResultados)
    RecyclerView rvResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_resultado);

        ButterKnife.bind(this);

        Intent i = getIntent();
        List<State> lista = (ArrayList<State>) i.getSerializableExtra(Constants.KEY_LIST);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.txt_resultado));

        rvResultados.setLayoutManager(new LinearLayoutManager(this));
        rvResultados.setHasFixedSize(true);

        rvResultados.setAdapter(new ResultadoAdapter(this, onClickItem(), lista));

    }

    private ResultadoAdapter.ResultadoOnClickListener onClickItem() {
        return new ResultadoAdapter.ResultadoOnClickListener() {
            @Override
            public void OnClickResultado(View view, int index) {

            }
        };
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



    private void getPoint(State s) {
        ApiService api = new ApiService();
        Retrofit retrofit = api.getInstance();
        IApiService iApiService = retrofit.create(IApiService.class);

        Call<Long> call = iApiService.getPoint(s);

        call.enqueue(new Callback<Long>() {


            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                String ok = "";
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                String ok = "";
            }
        });
    }
}
