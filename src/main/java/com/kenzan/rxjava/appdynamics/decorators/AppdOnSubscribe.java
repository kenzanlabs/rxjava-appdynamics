/**
 * 
 */
package com.kenzan.rxjava.appdynamics.decorators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * @author darshanrambhia
 * @param <T>
 *
 */
public class AppdOnSubscribe<T> implements OnSubscribe<T>{

    private String appdCorrelationKey;
    private final OnSubscribe<T> actual;
    
    public AppdOnSubscribe(final OnSubscribe<T> actual) {
        this.actual = actual;
    }

    @Override
    public void call(Subscriber<? super T> t) {
        
        actual.call(t);
    }
    
    public String getAppdCorrelationKey() {
        
        return this.appdCorrelationKey;
    }
    
    public void setAppdCorrelationKey(String correlationKey) {
        
        this.appdCorrelationKey = correlationKey;
    }
}