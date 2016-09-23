package com.kenzan.rxjava.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;


public class ObservableExecutionHookTest {
    
    @Before
    public void setUp() throws Exception {
        System.getProperties().put("rxjava.plugin.RxJavaObservableExecutionHook.implementation", "com.kenzan.rxjava.appdynamics.hook.ObservableExecutionHook");
    }
    
    @Test
    public void testSetUp() throws IOException {

        RxJavaObservableExecutionHook executionHook = RxJavaPlugins.getInstance().getObservableExecutionHook();
        assertTrue(executionHook instanceof ObservableExecutionHook);
    }
}