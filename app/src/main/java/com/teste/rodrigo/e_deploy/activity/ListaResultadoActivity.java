package com.teste.rodrigo.e_deploy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

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
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListaResultadoActivity extends AppCompatActivity {

    @BindView(R.id.rvResultados)
    RecyclerView rvResultados;

    List<State> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_resultado);

        ButterKnife.bind(this);

        Intent i = getIntent();
        mList = (ArrayList<State>) i.getSerializableExtra(Constants.KEY_LIST);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.txt_resultado));

        rvResultados.setLayoutManager(new LinearLayoutManager(this));
        rvResultados.setHasFixedSize(true);

        rvResultados.setAdapter(new ResultadoAdapter(this, onClickItem(), mList));

    }

    private ResultadoAdapter.ResultadoOnClickListener onClickItem() {
        return new ResultadoAdapter.ResultadoOnClickListener() {
            @Override
            public void OnClickResultado(View view, int index) {
                getPoint(mList.get(Integer.parseInt(view.getTag().toString())));
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
        iApiService.getPoint(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .doOnError(throwable -> onErrorHandling(throwable))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Intent i = new Intent(ListaResultadoActivity.this, PontuacaoActivity.class);
                        i.putExtra(Constants.KEY_PONTUACAO, String.valueOf(aLong));
                        i.putExtra(Constants.KEY_CIDADE, s.getNome());
                        startActivity(i);
                    }
                });
       /* ApiService api = new ApiService();
        Retrofit retrofit = api.getInstance();
        IApiService iApiService = retrofit.create(IApiService.class);

        Call<Long> call = iApiService.getPoint(s);

        call.enqueue(new Callback<Long>() {


            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Intent i = new Intent(ListaResultadoActivity.this, PontuacaoActivity.class);
                i.putExtra(Constants.KEY_PONTUACAO, response.body().toString());
                i.putExtra(Constants.KEY_CIDADE, s.getNome());
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                String ok = "";
            }
        });*/
    }

    private void onErrorHandling(Throwable e) {


    }
}
