package com.moofarm.wallet.service;

import com.moofarm.wallet.model.entity.Wallet;

public interface WalletInternalService {
    public Wallet debitFee(Wallet wallet, double moneyToBepaid);
}
