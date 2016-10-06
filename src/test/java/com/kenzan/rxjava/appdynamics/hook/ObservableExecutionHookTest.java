/**
 * Copyright © 2016 Kenzen, LLC (http://kenzan.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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