package com.teste.rodrigo.e_deploy.testeapagar;


/**
 * Created by rodrigobarbosa on 02/09/17.
 *//*


public class hahaha {
}

package com.b2wdigital.bonmarketplace.api;

        import android.content.Context;
        import android.content.SharedPreferences;

        import com.b2wdigital.bonmarketplace.BuildConfig;
        import com.b2wdigital.bonmarketplace.api.interceptor.ForbiddenIntefceptor;
        import com.b2wdigital.bonmarketplace.utils.constants.Configurations;
        import com.b2wdigital.bonmarketplace.utils.constants.SharedPreferencesConstants;
        import com.facebook.stetho.okhttp3.StethoInterceptor;
        import com.google.gson.FieldNamingPolicy;
        import com.google.gson.GsonBuilder;

        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import retrofit2.Retrofit;
        import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
        import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGeneratorBasicAuth {

    //public static final String API_BASE_URL = "https://your.api-base.url";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BuildConfig.URLAPIB2W)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass, Context context) {
        String basicAuth = "";
        if(context != null) {
            SharedPreferences prefs = context.getSharedPreferences(
                    SharedPreferencesConstants.APPPREFERENCES, Context.MODE_PRIVATE);
            basicAuth = prefs.getString(SharedPreferencesConstants.BASICAUTH, null);
        }
        return createService(serviceClass, basicAuth);
    }

    public static <S> S createService(Class<S> serviceClass, final String basicAuthToken, Boolean isLoginAction) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        if (basicAuthToken != null) {

            httpClient.interceptors().clear();

            httpClient.addNetworkInterceptor(new StethoInterceptor());

            if(!isLoginAction)
                httpClient.addInterceptor(new ForbiddenIntefceptor());

            httpClient.addInterceptor(chain -> {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", "Basic " + basicAuthToken)
                        .header("Accept", "application/json, text/plain, **/*
/*/import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;*/
/*")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
        }

        OkHttpClient client = httpClient
                .connectTimeout(Configurations.TIMEOUT_MAX, Configurations.TIMEOUT_TIME_UNIT)
                .readTimeout(Configurations.TIMEOUT_MAX, Configurations.TIMEOUT_TIME_UNIT)
                .build();
        Retrofit retrofit = builder
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);

    }

    public static <S> S createService(Class<S> serviceClass, final String basicAuthToken) {
        return createService(serviceClass, basicAuthToken, false);
    }

    */
/*public static <S> S createService(Class<S> serviceClass, String username, String password) {
        String credentials = username + ":" + password;
        final String basicAuthToken = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        return createService(serviceClass, basicAuthToken);
    }*//*

}*/




/*public void getChamados(String orderDirection, String orderField, String tab, final boolean isLoadMore, String user, String filterOption, String filterValue) {
        SacAPI api =
        ServiceGeneratorBasicAuth.createService(SacAPI.class, this);

        rlContainerWait.setVisibility(View.VISIBLE);

        api.getChamados(partnerSelected.getIdTerceiro(), limit, offset, orderDirection, orderField, tab, user, filterOption, filterValue)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .unsubscribeOn(Schedulers.io())
        .doOnError(throwable -> onErrorHandling(throwable))
        .subscribe(new Observer<Chamados>() {
@Override
public void onCompleted() {
        rlContainerWait.setVisibility(View.GONE);
        mAdapter.setMoreDataAvailable(false);

        }

@Override
public void onError(Throwable e) {
        rlContainerWait.setVisibility(View.GONE);
        }

@Override
public void onNext(Chamados chamados) {

        if (mAdapter.getChamados().size() == 0 && chamados.getLstChamados().length == 0)
        containerNotFound.setVisibility(View.VISIBLE);
        else {
        rlContainerWait.setVisibility(View.GONE);
        containerNotFound.setVisibility(View.GONE);

        if (chamados.getLstChamados().length != 0) {
        if (isLoadMore)
        mAdapter.getChamados().remove(mAdapter.getChamados().size() - 1);
        if (chamados.getLstChamados().length > 0) {
        int sizeList = mAdapter.getChamados().size();
        mAdapter.getChamados().addAll(Arrays.asList(chamados.getLstChamados()));
        offset = mAdapter.getChamados().size() + 1;
        setList(isLoadMore, sizeList);
        } else {
        mAdapter.setMoreDataAvailable(false);
        }

        mAdapter.notifyDataChanged();
        }


        }

        }
        });

        }*/


/*
@Multipart
@POST(BuildConfig.YODA_PORTAL_PREFIXO + "/ticket/action/{actionId}/operation/{operId}/partner/{partnerId}/user/{userId}/answer")
    Observable<Void> responderMensagem(@Path(value = "actionId") String action,
@Path(value = "operId") Long operId,
@Path(value = "partnerId") Long partnerId,
@Path(value = "userId") String userId,
@Query(value = "electedDate") Long electedDate,
@Query(value = "idExec") Long idExec,
@Query(value = "obs") String obs,
@Part MultipartBody.Part file);*/
