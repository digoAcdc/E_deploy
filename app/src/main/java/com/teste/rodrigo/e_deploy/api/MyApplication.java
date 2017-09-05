package com.teste.rodrigo.e_deploy.api;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by rodrigobarbosa on 05/09/17.
 */

public class MyApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
