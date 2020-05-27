package com.moofarm.wallet.service;

import com.moofarm.wallet.constants.ResponseMessages;
import com.moofarm.wallet.model.InsufficientBalanceException;
import com.moofarm.wallet.model.WalletResponse;
import com.moofarm.wallet.model.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.http.HTTPException;

@ControllerAdvice(basePackages = {"com.moofarm.wallet.controller"})
public class MoofarmExceptionHadler {

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseBody
    public final ResponseEntity handleInsufficientBalanception(InsufficientBalanceException isufficientBalanceException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getSuccessReponse());
    }


    @ExceptionHandler(HTTPException.class)
    @ResponseBody
    public final ResponseEntity handleHttpException(HTTPException httpException) {
        return ResponseEntity.status(httpException.getStatusCode()).body(createResponse(httpException));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createResponse(exception));
    }

    private WalletResponse getSuccessReponse() {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setStatusCode(StatusCode.BAD_REQUEST);
        walletResponse.setMessage(ResponseMessages.INSUFFICIENT_BALANCE);
        return walletResponse;

    }

    private WalletResponse createResponse(HTTPException httpException) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setStatusCode(StatusCode.getStatusCode(httpException.getStatusCode()));
        walletResponse.setMessage(httpException.getMessage());
        return walletResponse;

    }

    private WalletResponse createResponse(Exception exception) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR);
        walletResponse.setMessage(exception.getMessage());
        return walletResponse;

    }

}
