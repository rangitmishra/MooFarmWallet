package com.moofarm.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyDepositRequest {
    @JsonProperty("bonus_amount")
    private double bonusAmount;
    @JsonProperty("fixed_amount")
    private double fixedAmount;
    @JsonProperty("winning_amount")
    private double winningAmount;

    public MoneyDepositRequest() {
    }

    public MoneyDepositRequest(double bonusAmount, double fixedAmount, double winningAmount) {
        this.bonusAmount = bonusAmount;
        this.fixedAmount = fixedAmount;
        this.winningAmount = winningAmount;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(double winningAmount) {
        this.winningAmount = winningAmount;
    }
}
