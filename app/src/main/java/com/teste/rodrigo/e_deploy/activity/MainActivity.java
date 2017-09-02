package com.teste.rodrigo.e_deploy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teste.rodrigo.e_deploy.R;
import com.teste.rodrigo.e_deploy.api.ApiService;
import com.teste.rodrigo.e_deploy.api.IApiService;
import com.teste.rodrigo.e_deploy.model.State;

import java.util.List;
import java.util.stream.Collectors;


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


        getStates();
String teste1 = " ";
        List<State> lista =  mStates.stream().filter(s -> s.getEstado().contains("Acre")).collect(Collectors.toList());

        String teste = "";


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


    }

    private void getPoint(State s){
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
