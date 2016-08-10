/**
 * 
 */
package net.kenzan.rxjava.appdynamics.hook;

import net.kenzan.rxjava.appdynamics.decorators.AppdOnSubscribe;
import net.kenzan.rxjava.appdynamics.decorators.AppdOperator;
import net.kenzan.rxjava.appdynamics.decorators.AppdSubscription;
import rx.Observable;
import rx.Subscription;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.plugins.RxJavaObservableExecutionHook;

/**
 * @author darshanrambhia
 *
 */
public class ObservableExecutionHook extends RxJavaObservableExecutionHook {
    
    /* (non-Javadoc)
     * @see rx.plugins.RxJavaObservableExecutionHook#onCreate(rx.Observable.OnSubscribe)
     */
    @Override
    public <T> OnSubscribe<T> onCreate(OnSubscribe<T> f) {
        
        return new AppdOnSubscribe<T>(f);
    }
    
    /* (non-Javadoc)
     * @see rx.plugins.RxJavaObservableExecutionHook#onSubscribeStart(rx.Observable, rx.Observable.OnSubscribe)
     */
    @Override
    public <T> OnSubscribe<T> onSubscribeStart(Observable<? extends T> observableInstance, OnSubscribe<T> onSubscribe) {

        return new AppdOnSubscribe<T>(onSubscribe);
    }
    
    /* (non-Javadoc)
     * @see rx.plugins.RxJavaObservableExecutionHook#onLift(rx.Observable.Operator)
     */
    @Override
    public <T, R> Operator<? extends R, ? super T> onLift(Operator<? extends R, ? super T> lift) {
        
        return new AppdOperator<R, T>(lift);
    }
    
    /* (non-Javadoc)
     * @see rx.plugins.RxJavaObservableExecutionHook#onSubscribeReturn(rx.Subscription)
     */
    @Override
    public <T> Subscription onSubscribeReturn(Subscription subscription) {
        
        return new AppdSubscription(subscription);
    }
    
    /* (non-Javadoc)
     * @see rx.plugins.RxJavaObservableExecutionHook#onSubscribeError(java.lang.Throwable)
     */
    @Override
    public <T> Throwable onSubscribeError(Throwable e) {
        
        return e;
    }
}