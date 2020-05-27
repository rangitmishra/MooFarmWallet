package com.moofarm.wallet.controller;

import com.moofarm.wallet.constants.ResponseMessages;
import com.moofarm.wallet.model.CheckBalanceResponse;
import com.moofarm.wallet.model.ContestPartcipationRequest;
import com.moofarm.wallet.model.WalletResponse;
import com.moofarm.wallet.model.StatusCode;
import com.moofarm.wallet.model.entity.Wallet;
import com.moofarm.wallet.service.IMoofarmWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private IMoofarmWalletService moofarmWalletService;

    @PostMapping("/participate")
    public WalletResponse depositMonet(@RequestBody ContestPartcipationRequest contestPartcipationRequest) {
        Wallet wallet = moofarmWalletService.debitMoneyFromWallet(contestPartcipationRequest);
        return gettCheckBalanceResponse(wallet);

    }

    private CheckBalanceResponse gettCheckBalanceResponse(Wallet wallet) {
        CheckBalanceResponse checkBalanceResponse = new CheckBalanceResponse();
        checkBalanceResponse.setStatusCode(StatusCode.SUCCESS);
        checkBalanceResponse.setMessage(ResponseMessages.BALANCE_AFTER_CONTEST_SUCCESS_MESSAGE);
        checkBalanceResponse.setWallet(wallet);
        return checkBalanceResponse;

    }

}
