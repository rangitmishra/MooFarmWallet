package com.moofarm.wallet.service;

import com.moofarm.wallet.model.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bonusWallet")
public class BonusWallet implements WalletInternalService {

    @Autowired
    @Qualifier("fixedWallet")
    private WalletInternalService walletInternalService;

    @Override
    public Wallet debitFee(Wallet wallet, double moneyToBepaid) {
        double bonusAmountDebit = wallet.getBonusAmount()*0.1;
        wallet.setBonusAmount(wallet.getBonusAmount()-bonusAmountDebit);
        return walletInternalService.debitFee(wallet, moneyToBepaid - bonusAmountDebit);
    }
}
