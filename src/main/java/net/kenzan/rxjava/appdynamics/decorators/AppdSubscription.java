/**
 * 
 */
package net.kenzan.rxjava.appdynamics.decorators;

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
