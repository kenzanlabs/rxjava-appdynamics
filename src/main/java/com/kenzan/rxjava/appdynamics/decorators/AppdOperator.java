/**
 * 
 */
package com.kenzan.rxjava.appdynamics.decorators;

import rx.Observable.Operator;
import rx.Subscriber;

/**
 * @author darshanrambhia
 * @param <R>
 * @param <T>
 *
 */
public class AppdOperator<R, T> implements Operator<R, T> {

    private String appdCorrelationKey;
    private final Operator<? extends R, ? super T> actual;
    
    public AppdOperator(final Operator<? extends R, ? super T> actual) {
        this.actual = actual;
    }

    @Override
    public Subscriber<? super T> call(Subscriber<? super R> t) {
        
        return actual.call(t);
    }
    
    public String getAppdCorrelationKey() {
        
        return this.appdCorrelationKey;
    }
    
    public void setAppdCorrelationKey(String correlationKey) {
        
        this.appdCorrelationKey = correlationKey;
    }
}
