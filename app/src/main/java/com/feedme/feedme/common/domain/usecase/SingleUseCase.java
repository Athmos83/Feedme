package com.feedme.feedme.common.domain.usecase;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class SingleUseCase<T> {

    protected abstract Single<T> execute();

    public Disposable subscribe(Consumer<T> observer) {
        return execute().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
