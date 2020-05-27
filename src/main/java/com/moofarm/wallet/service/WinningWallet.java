package com.moofarm.wallet.service;

import com.moofarm.wallet.model.entity.Wallet;
import org.springframework.stereotype.Service;

@Service("winningWallet")
public class WinningWallet implements WalletInternalService {
    @Override
    public Wallet debitFee(Wallet wallet, double moneyToBepaid) {
        wallet.setWinningAmount(wallet.getWinningAmount() - moneyToBepaid);
        return wallet;
    }
}
