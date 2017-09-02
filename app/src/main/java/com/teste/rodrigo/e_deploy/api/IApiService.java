package com.teste.rodrigo.e_deploy.api;

import com.teste.rodrigo.e_deploy.model.State;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by not on 01/09/2017.
 */

public interface IApiService {

//    @GET("/Master/CidadeServico.svc/rest/BuscaTodasCidades")
//    Observable<States> getListStates();

    @GET("Master/CidadeServico.svc/rest/BuscaTodasCidades")
    Call<List<State>> getListStates();

    @POST("Master/CidadeServico.svc/rest/BuscaPontos")
    Call<Long> getPoint(@Body State state);

    /*@POST("Master/CidadeServico.svc/rest/BuscaPontos")
    Observable<Long> getPoint(@Query("State") State state);*/
}
