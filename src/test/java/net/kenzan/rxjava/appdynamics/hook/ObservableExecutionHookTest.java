package net.kenzan.rxjava.appdynamics.hook;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.netflix.config.ConfigurationManager;

import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;


public class ObservableExecutionHookTest {
    
    @Before
    public void setUp() throws Exception {
    
        ConfigurationManager.loadPropertiesFromResources("rxjava-appdynamics.properties");
    }
    
    @Test
    public void testSetUp() {

        RxJavaObservableExecutionHook executionHook = RxJavaPlugins.getInstance().getObservableExecutionHook();
        assertTrue(executionHook instanceof ObservableExecutionHook);
    }
}