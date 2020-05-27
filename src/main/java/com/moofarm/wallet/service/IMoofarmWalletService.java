package com.moofarm.wallet.service;


import com.moofarm.wallet.model.ContestPartcipationRequest;
import com.moofarm.wallet.model.MoneyDepositRequest;
import com.moofarm.wallet.model.entity.Wallet;

public interface IMoofarmWalletService {
    boolean depositMoneyIntoWallet(MoneyDepositRequest moneyDepositRequest);
    Wallet checkBalance();
    Wallet debitMoneyFromWallet(ContestPartcipationRequest contestPartcipationRequest);
}
