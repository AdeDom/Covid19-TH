package com.adedom.covid19_th;

import com.google.gson.annotations.SerializedName;

public class Covid19Response {

    @SerializedName("Confirmed")
    private int confirmed;

    @SerializedName("Recovered")
    private int recovered;

    @SerializedName("Hospitalized")
    private int hospitalized;

    @SerializedName("Deaths")
    private int deaths;

    @SerializedName("NewConfirmed")
    private int newConfirmed;

    @SerializedName("NewRecovered")
    private int newRecovered;

    @SerializedName("NewHospitalized")
    private int newHospitalized;

    @SerializedName("NewDeaths")
    private int newDeaths;

    @SerializedName("UpdateDate")
    private String updateDate;

    @SerializedName("Source")
    private String source;

    public int getConfirmed() {
        return confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public int getNewHospitalized() {
        return newHospitalized;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getSource() {
        return source;
    }

}
