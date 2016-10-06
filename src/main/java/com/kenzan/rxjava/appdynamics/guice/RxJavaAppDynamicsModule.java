package com.kenzan.rxjava.appdynamics.guice;

import com.google.inject.AbstractModule;
import com.kenzan.rxjava.appdynamics.hook.ObservableExecutionHook;

import rx.plugins.RxJavaPlugins;

public class RxJavaAppDynamicsModule extends AbstractModule {
    @Override
    protected void configure() {
        RxJavaPlugins.getInstance().registerObservableExecutionHook(new ObservableExecutionHook());
    }
}
