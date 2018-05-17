package com.example.kiennguyentrung.learnbaseapp.domain.fetcher;

public interface ResultListener<T> {

    void onRequestStart();

    void onRequestSuccess(T response);

    void onRequestError(Throwable error);
}
