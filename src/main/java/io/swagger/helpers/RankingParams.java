package io.swagger.helpers;

import java.io.Serializable;

public class RankingParams implements Serializable {
    //Stores the Weight Id to be used in the ranking
    private String rankingId;
    //Stores if the results will be inverted (ASC order)
    private Boolean inverted;


    public RankingParams() {
    }

    public RankingParams(String rankingId) {
        this.rankingId = rankingId;
    }

    public RankingParams(String rankingId, Boolean inverted) {
        this.rankingId = rankingId;
        this.inverted = inverted;
    }


    // --- Getters and Setters

    public String getRankingId() {
        return rankingId;
    }

    public void setRankingId(String rankingId) {
        this.rankingId = rankingId;
    }

    public Boolean getInverted() { return inverted; }

    public void setInverted(Boolean inverted) { this.inverted = inverted; }
}
