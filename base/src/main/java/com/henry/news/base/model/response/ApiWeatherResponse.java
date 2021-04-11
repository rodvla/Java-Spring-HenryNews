package com.henry.news.base.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ApiWeatherResponse {

    @SerializedName("location")
    private Location location;

    @SerializedName("current")
    private Current current;
}
