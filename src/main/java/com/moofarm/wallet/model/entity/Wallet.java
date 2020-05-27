package com.moofarm.wallet.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bonus_amount")
    private double bonusAmount;

    @Column(name = "fixed_amount")
    private double fixedAmount;

    @Column(name = "winning_amount")
    private double winningAmount;

    public Wallet() {
    }

    public Wallet(double bonusAmount, double fixedAmount, double winningAmount) {
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
