package com.moofarm.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletResponse {
    @JsonProperty("status_code")
    private StatusCode statusCode;
    @JsonProperty("message")
    private String message;

    public WalletResponse() {
    }

    public WalletResponse(StatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
