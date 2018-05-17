package com.example.kiennguyentrung.learnbaseapp.domain.fetcher;

import org.reactivestreams.Subscription;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class Fetcher {

    private CompositeDisposable disposable;

    @Inject
    public Fetcher(CompositeDisposable disposable) {
        this.disposable = disposable;
    }

    public <T> void fetch(Flowable<T> flowable, final ResultListener<T> resultListener) {
        disposable.add(flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {
                        resultListener.onRequestStart();
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        resultListener.onRequestSuccess(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        resultListener.onRequestError(throwable);
                    }
                }));
    }

    public <T> void fetch(Observable<T> observable, final ResultListener<T> resultListener) {
        disposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        resultListener.onRequestStart();
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        resultListener.onRequestSuccess(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        resultListener.onRequestError(throwable);
                    }
                }));
    }

    public <T> void fetch(Completable completable, final ResultListener<T> resultListener) {
        disposable.add(completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        resultListener.onRequestStart();
                    }
                })
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }

    public <T> void fetch(Single<T> single, final ResultListener<T> resultListener) {
        disposable.add(single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        resultListener.onRequestStart();
                    }
                })
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        resultListener.onRequestSuccess(t);
                    }
                }, new Consumer<Throwable>() {

                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        resultListener.onRequestError(throwable);
                    }
                }));
    }

    public void clear() {
        disposable.clear();
    }

    public void cancelAllRequest() {
        disposable.clear();
    }
}
