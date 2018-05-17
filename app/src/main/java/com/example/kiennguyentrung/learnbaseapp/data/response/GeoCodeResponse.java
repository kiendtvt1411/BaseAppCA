package com.example.kiennguyentrung.learnbaseapp.data.response;

import com.example.kiennguyentrung.learnbaseapp.data.response.model.GeoCodeModel;

import java.util.ArrayList;
import java.util.List;

public class GeoCodeResponse {

    public String status;
    public List<GeoCodeModel> results = new ArrayList<>();
}
