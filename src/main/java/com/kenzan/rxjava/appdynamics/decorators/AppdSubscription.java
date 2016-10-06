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
/**
 * 
 */
package com.kenzan.rxjava.appdynamics.decorators;

import rx.Subscription;

/**
 * @author darshanrambhia
 *
 */
public class AppdSubscription implements Subscription {
    
    private String appdCorrelationKey;
    private final Subscription actual;
    
    public AppdSubscription(final Subscription actual) {
        this.actual = actual;
    }
    
    /* (non-Javadoc)
     * @see rx.Subscription#unsubscribe()
     */
    @Override
    public void unsubscribe() {
        
        actual.unsubscribe();
    }
    
    /* (non-Javadoc)
     * @see rx.Subscription#isUnsubscribed()
     */
    @Override
    public boolean isUnsubscribed() {

        return actual.isUnsubscribed();
    }
    
    public String getAppdCorrelationKey() {
        
        return this.appdCorrelationKey;
    }
    
    public void setAppdCorrelationKey(String correlationKey) {
        
        this.appdCorrelationKey = correlationKey;
    }
}
