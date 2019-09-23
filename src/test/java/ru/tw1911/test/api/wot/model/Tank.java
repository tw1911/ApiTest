package ru.tw1911.test.api.wot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "statistics",
        "mark_of_mastery",
        "tank_id"
})
public class Tank {

    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("mark_of_mastery")
    private Integer markOfMastery;
    @JsonProperty("tank_id")
    private Integer tankId;

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("mark_of_mastery")
    public Integer getMarkOfMastery() {
        return markOfMastery;
    }

    @JsonProperty("mark_of_mastery")
    public void setMarkOfMastery(Integer markOfMastery) {
        this.markOfMastery = markOfMastery;
    }

    @JsonProperty("tank_id")
    public Integer getTankId() {
        return tankId;
    }

    @JsonProperty("tank_id")
    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

}