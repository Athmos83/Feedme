package com.feedme.feedme.common.view;

import android.support.annotation.UiThread;

import com.feedme.feedme.common.domain.model.BaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseView> {

    protected WeakReference<V> view;
    protected WeakReference<CompositeDisposable> subscriptions;

    @UiThread
    public void attachView(V view) {
        this.view = new WeakReference(view);
    }

    @UiThread
    public void detachView() {
        clearSubscriptions();
        clearView();
    }

    @UiThread
    public void addSubscription(Disposable disposable) {
        if (subscriptions == null)
            subscriptions = new WeakReference<>(new CompositeDisposable());
        if (subscriptions.get() == null) return;
        subscriptions.get().add(disposable);
    }

    @UiThread
    public V getView() {
        return view == null ? null : view.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }

    // Private methods

    private void clearView() {
        if (view == null) return;
        view.clear();
        view = null;
    }

    private void clearSubscriptions() {
        if (subscriptions == null) return;
        if (subscriptions.get() != null)
            subscriptions.get().dispose();
        subscriptions.clear();
        subscriptions = null;
    }
}
