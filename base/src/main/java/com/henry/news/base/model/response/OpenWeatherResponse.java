package com.henry.news.base.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenWeatherResponse {

    @SerializedName("main")
    private Main main;

    @SerializedName("name")
    private String name;
}
