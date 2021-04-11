package com.henry.news.base.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Current {

    @SerializedName("last_updated_epoch")
    private Integer lastUpdatedEpoch;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("temp_c")
    private Double tempC;

    @SerializedName("temp_f")
    private Double tempF;

    @SerializedName("is_day")
    private Integer isDay;

    @SerializedName("wind_mph")
    private Double windMph;

    @SerializedName("wind_kph")
    private Double windKph;

    @SerializedName("wind_degree")
    private Integer windDegree;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("pressure_mb")
    private Double pressureMb;

    @SerializedName("pressure_in")
    private Double pressureIn;

    @SerializedName("precip_mm")
    private Double precipMm;

    @SerializedName("precip_in")
    private Double precipIn;

    @SerializedName("humidity")
    private Integer humidity;

    @SerializedName("cloud")
    private Integer cloud;

    @SerializedName("feelslike_c")
    private Double feelslikeC;

    @SerializedName("feelslike_f")
    private Double feelslikeF;

    @SerializedName("vis_km")
    private Double visKm;

    @SerializedName("vis_miles")
    private Double visMiles;

    @SerializedName("uv")
    private Double uv;

    @SerializedName("gust_mph")
    private Double gustMph;

    @SerializedName("gust_kph")
    private Double gustKph;
}
