package com.teste.rodrigo.e_deploy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teste.rodrigo.e_deploy.R;
import com.teste.rodrigo.e_deploy.api.ApiService;
import com.teste.rodrigo.e_deploy.api.IApiService;
import com.teste.rodrigo.e_deploy.model.State;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiService api;
    Retrofit retrofit;
    IApiService iApiService;
    List<State> mStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*api = new ApiService();
        retrofit = api.getInstance();
        iApiService = retrofit.create(IApiService.class);*/
        getPoint();
       // getStates();
    }

    private void getStates() {
        ApiService api = new ApiService();
        Retrofit retrofit = api.getInstance();
        IApiService iApiService = retrofit.create(IApiService.class);
        Call<List<State>> call = iApiService.getListStates();

        call.enqueue(new Callback<List<State>>() {

            @Override
            public void onResponse(Call<List<State>> call, Response<List<State>> response) {
                mStates = response.body();
            }

            @Override
            public void onFailure(Call<List<State>> call, Throwable t) {
                String erro = "";
            }
        });

        /*iApiService.getListStates()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<States>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(States states) {
                        mStates = states.getLstStates() ;
                    }
                });*/
    }

    private void getPoint(){
        ApiService api = new ApiService();
        Retrofit retrofit = api.getInstance();
        IApiService iApiService = retrofit.create(IApiService.class);

        State s = new State();
        s.setEstado("Acre");
        s.setNome("Acrelândia");
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
