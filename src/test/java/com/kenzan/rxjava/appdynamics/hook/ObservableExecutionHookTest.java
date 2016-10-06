package com.kenzan.rxjava.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.inject.Binder;
import com.kenzan.rxjava.appdynamics.guice.RxJavaAppDynamicsModule;

import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaPluginsTest;

@RunWith(MockitoJUnitRunner.class)
public class ObservableExecutionHookTest {
    @Mock
    private Binder binder;

    @Before
    public void tearDown() {
        System.getProperties().remove("rxjava.plugin.RxJavaObservableExecutionHook.implementation");
        RxJavaPluginsTest.resetPlugins();
    }

    @Test
    public void systemProperties() throws IOException {
        System.getProperties().put("rxjava.plugin.RxJavaObservableExecutionHook.implementation",
                "com.kenzan.rxjava.appdynamics.hook.ObservableExecutionHook");
        RxJavaObservableExecutionHook executionHook = RxJavaPlugins.getInstance().getObservableExecutionHook();
        assertTrue(executionHook instanceof ObservableExecutionHook);
    }

    @Test
    public void guice() throws IOException {
        new RxJavaAppDynamicsModule().configure(binder);
        RxJavaObservableExecutionHook executionHook = RxJavaPlugins.getInstance().getObservableExecutionHook();
        assertTrue(executionHook instanceof ObservableExecutionHook);
    }
}