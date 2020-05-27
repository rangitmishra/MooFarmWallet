package com.moofarm.wallet.service;

import com.moofarm.wallet.model.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fixedWallet")
public class FixedWallet implements WalletInternalService {

    @Autowired
    @Qualifier("winningWallet")
    private WalletInternalService walletInternalService;

    @Override
    public Wallet debitFee(Wallet wallet, double moneyToBepaid) {
        double fixAmount = wallet.getFixedAmount();
        if(moneyToBepaid < fixAmount) {
            wallet.setFixedAmount(fixAmount - moneyToBepaid);
            return wallet;
        } else {
            wallet.setFixedAmount(0.0);
            return walletInternalService.debitFee(wallet, moneyToBepaid - fixAmount);
        }
    }
}
