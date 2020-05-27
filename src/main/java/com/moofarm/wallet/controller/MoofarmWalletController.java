package com.moofarm.wallet.controller;

import com.moofarm.wallet.constants.ResponseMessages;
import com.moofarm.wallet.model.CheckBalanceResponse;
import com.moofarm.wallet.model.MoneyDepositRequest;
import com.moofarm.wallet.model.StatusCode;
import com.moofarm.wallet.model.WalletResponse;
import com.moofarm.wallet.model.entity.Wallet;
import com.moofarm.wallet.service.IMoofarmWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class MoofarmWalletController {

    @Autowired
    private IMoofarmWalletService moofarmWalletService;

    @PostMapping("/money/deposit")
    public WalletResponse depositMonet(@RequestBody MoneyDepositRequest moneyDepositRequest) {
        boolean isDeposited = moofarmWalletService.depositMoneyIntoWallet(moneyDepositRequest);
        WalletResponse walletResponse = null;

        if(isDeposited) {
            walletResponse = getSuccessReponse();
        }
        return walletResponse;

    }

    @GetMapping("/money/balance")
    public CheckBalanceResponse checkBalance() {
        Wallet wallet=  moofarmWalletService.checkBalance();
        CheckBalanceResponse checkBalanceResponse = gettCheckBalanceResponse(wallet);
        return checkBalanceResponse;
    }

    private CheckBalanceResponse gettCheckBalanceResponse(Wallet wallet) {
        CheckBalanceResponse checkBalanceResponse = new CheckBalanceResponse();
        checkBalanceResponse.setStatusCode(StatusCode.SUCCESS);
        checkBalanceResponse.setMessage(ResponseMessages.CHECK_BALANCE_SUCCESS_MESSAGE);
        checkBalanceResponse.setWallet(wallet);
        return checkBalanceResponse;

    }

    private WalletResponse getSuccessReponse() {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setStatusCode(StatusCode.SUCCESS);
        walletResponse.setMessage(ResponseMessages.DEPOSIT_SUCCESS_MESSAGE);
        return walletResponse;

    }
}
