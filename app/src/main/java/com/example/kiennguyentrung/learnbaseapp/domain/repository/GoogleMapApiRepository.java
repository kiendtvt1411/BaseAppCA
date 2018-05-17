package com.example.kiennguyentrung.learnbaseapp.domain.repository;

import com.example.kiennguyentrung.learnbaseapp.data.response.GeoCodeResponse;

import io.reactivex.Observable;

public interface GoogleMapApiRepository {

    Observable<GeoCodeResponse> getSchedulesOutline(String address, String key);
}
