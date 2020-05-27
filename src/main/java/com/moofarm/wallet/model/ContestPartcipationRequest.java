package com.moofarm.wallet.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContestPartcipationRequest {
    @JsonProperty("entry_fee")
    private double entryFee;

    @JsonProperty("discount")
    private double discount;

    public ContestPartcipationRequest(double entryFee, double discount) {
        this.entryFee = entryFee;
        this.discount = discount;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
