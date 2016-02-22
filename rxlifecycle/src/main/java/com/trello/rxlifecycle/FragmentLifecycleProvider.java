package com.trello.rxlifecycle;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import rx.Observable;

/**
 * Common interface for all RxFragment extensions.
 *
 * Useful if you are writing utilities on top of rxlifecycle-components,
 * or you are implementing your own component not supported in this library.
 */
public interface FragmentLifecycleProvider {

    /**
     * @return a sequence of {@link android.app.Fragment} lifecycle events
     */
    @NonNull
    @CheckResult
    Observable<FragmentEvent> lifecycle();

    /**
     * Binds a source until a specific {@link FragmentEvent} occurs.
     * <p>
     * Intended for use with {@link Observable#compose(Observable.Transformer)}
     *
     * @param event the {@link FragmentEvent} that triggers unsubscription
     * @return a reusable {@link rx.Observable.Transformer} which unsubscribes when the event triggers.
     */
    @NonNull
    @CheckResult
    <T> Observable.Transformer<T, T> bindUntilEvent(@NonNull FragmentEvent event);

    /**
     * Binds a source until the next reasonable {@link FragmentEvent} occurs.
     * <p>
     * Intended for use with {@link Observable#compose(Observable.Transformer)}
     *
     * @return a reusable {@link rx.Observable.Transformer} which unsubscribes at the correct time.
     */
    @NonNull
    @CheckResult
    <T> Observable.Transformer<T, T> bindToLifecycle();

}
