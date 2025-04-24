package com.example.api_projectpplg;

import com.google.gson.annotations.SerializedName;

public class Tim {

    private String strTeam;
    private String strStadium;
    private String strBadge;

    public Tim(String strTeam, String strStadium, String strBadge) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strBadge = strBadge;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
