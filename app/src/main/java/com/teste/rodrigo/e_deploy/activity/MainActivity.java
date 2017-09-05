package com.teste.rodrigo.e_deploy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teste.rodrigo.e_deploy.Constants.Constants;
import com.teste.rodrigo.e_deploy.R;
import com.teste.rodrigo.e_deploy.api.ApiService;
import com.teste.rodrigo.e_deploy.api.IApiService;
import com.teste.rodrigo.e_deploy.model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ApiService api;
    Retrofit retrofit;
    IApiService iApiService;
    List<State> mStates;

    @BindView(R.id.etCidade)
    protected EditText etCidade;

    @BindView(R.id.etEstado)
    protected EditText etEstado;

    @BindView(R.id.btBuscar)
    protected Button btBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        getStates();


    }

    private void getStates() {


        ApiService api = new ApiService();
        Retrofit retrofit = api.getInstance();
        IApiService iApiService = retrofit.create(IApiService.class);
        iApiService.getListStates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .doOnError(throwable -> onErrorHandling(throwable))
                .subscribe(new Observer<List<State>>() {
                    @Override
                    public void onCompleted() {
                        String erro = "";
                    }

                    @Override
                    public void onError(Throwable e) {
                        String erro = "";
                    }

                    @Override
                    public void onNext(List<State> state) {
                        mStates = state;
                    }
                });




    }

    private void onErrorHandling(Throwable e) {


    }

    @OnClick(R.id.btBuscar)
    protected void onClickBuscar() {
        List<State> listaFiltrada = filtrar(etCidade.getText().toString().toUpperCase(), etEstado.getText().toString().toUpperCase());

        Intent i = new Intent(this, ListaResultadoActivity.class);
        i.putParcelableArrayListExtra(Constants.KEY_LIST, (ArrayList<? extends Parcelable>) listaFiltrada);

        startActivity(i);

    }

    public List<State> filtrar(String cidade, String estado) {

        List<State> lista = new ArrayList<>();

        for (State s : mStates) {

            if (cidade.equalsIgnoreCase("")) {
                if (s.getEstado().toUpperCase().startsWith(estado)) {
                    lista.add(s);
                }
            } else if (estado.equalsIgnoreCase("")) {
                if (s.getNome().toUpperCase().startsWith(cidade)) {
                    lista.add(s);
                }
            } else {
                if (s.getEstado().toUpperCase().startsWith(estado) && s.getNome().toUpperCase().startsWith(cidade)) {
                    lista.add(s);
                }
            }


        }
        return lista;
    }


}
