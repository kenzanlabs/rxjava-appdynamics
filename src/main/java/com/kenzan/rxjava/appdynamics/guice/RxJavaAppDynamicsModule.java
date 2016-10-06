/**
 * Copyright © 2016 Kenzan, LLC (http://kenzan.com)
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
