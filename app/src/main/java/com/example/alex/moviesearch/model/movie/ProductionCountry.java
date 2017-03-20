package com.example.alex.moviesearch.model.movie;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 3/4/2017.
 */

public class ProductionCountry {

    @SerializedName("iso_3166_1")
    String isoCountryName;

    @SerializedName("name")
    String countryName;

    public String getIsoCountryName() {
        return isoCountryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
