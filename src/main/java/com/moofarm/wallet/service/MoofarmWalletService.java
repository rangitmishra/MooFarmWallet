package com.moofarm.wallet.service;

import com.moofarm.wallet.model.ContestPartcipationRequest;
import com.moofarm.wallet.model.InsufficientBalanceException;
import com.moofarm.wallet.model.MoneyDepositRequest;
import com.moofarm.wallet.model.entity.Wallet;
import com.moofarm.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MoofarmWalletService  implements IMoofarmWalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    @Qualifier("bonusWallet")
    private WalletInternalService walletInternalService;

    @Override
    public boolean depositMoneyIntoWallet(MoneyDepositRequest moneyDepositRequest) {
        List<Wallet> wallets = (List<Wallet>) walletRepository.findAll();
        Wallet wallet;
        if(wallets.isEmpty()) {
            wallet = new Wallet(moneyDepositRequest.getBonusAmount(), moneyDepositRequest.getFixedAmount(),
                    moneyDepositRequest.getWinningAmount());
        } else {
            wallet = wallets.get(0);
            incrementMoneyInWallet(moneyDepositRequest, wallet);
        }
        return Objects.nonNull(walletRepository.save(wallet));

    }

    @Override
    public Wallet checkBalance() {
        List<Wallet> wallets = (List<Wallet>) walletRepository.findAll();
        Wallet wallet = new Wallet();
        if(!wallets.isEmpty()) {
            wallet = wallets.get(0);
        }
        return wallet;
    }

    @Override
    public Wallet debitMoneyFromWallet(ContestPartcipationRequest contestPartcipationRequest) {
        List<Wallet> wallets = (List<Wallet>) walletRepository.findAll();
        if(wallets.isEmpty() || isInSufficientBalance(wallets.get(0), contestPartcipationRequest))
            throw new InsufficientBalanceException("Insufficient Balance.");

        Wallet wallet = wallets.get(0);
        double entryFeeAfterDiscount =  contestPartcipationRequest.getEntryFee() -
                (contestPartcipationRequest.getEntryFee()*contestPartcipationRequest.getDiscount())/100;
        wallet = walletInternalService.debitFee(wallet, entryFeeAfterDiscount);
        return walletRepository.save(wallet);
    }

    private boolean isInSufficientBalance(Wallet wallet, ContestPartcipationRequest contestPartcipationRequest) {
        double entryFeeAfterDiscount = contestPartcipationRequest.getEntryFee() -
                (contestPartcipationRequest.getEntryFee()*contestPartcipationRequest.getDiscount())/100;
        double effectiveBalnceForFee = 0.1*wallet.getBonusAmount() + wallet.getFixedAmount() + wallet.getWinningAmount();
        return entryFeeAfterDiscount > effectiveBalnceForFee;
    }

    private void incrementMoneyInWallet(MoneyDepositRequest moneyDepositRequest, Wallet wallet) {
        wallet.setBonusAmount(wallet.getBonusAmount() + moneyDepositRequest.getBonusAmount());
        wallet.setFixedAmount(wallet.getFixedAmount() + moneyDepositRequest.getFixedAmount());
        wallet.setWinningAmount(wallet.getWinningAmount() + moneyDepositRequest.getWinningAmount());
    }
}
