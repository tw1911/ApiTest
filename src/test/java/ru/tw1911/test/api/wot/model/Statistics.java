package ru.tw1911.test.api.wot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "wins",
        "battles"
})
public class Statistics {

    @JsonProperty("wins")
    private Integer wins;
    @JsonProperty("battles")
    private Integer battles;

    @JsonProperty("wins")
    public Integer getWins() {
        return wins;
    }

    @JsonProperty("wins")
    public void setWins(Integer wins) {
        this.wins = wins;
    }

    @JsonProperty("battles")
    public Integer getBattles() {
        return battles;
    }

    @JsonProperty("battles")
    public void setBattles(Integer battles) {
        this.battles = battles;
    }

}