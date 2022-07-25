package com.example.library.response;

public class ResponseStatus {

    private Integer statusCode;
    private String statusMessage;

    private static final Integer SUCCESS_CODE = 1;
    private static final String  SUCCESS_MESSAGE = "success";


    public ResponseStatus(Integer statusCode, String statusMessage){
        this.statusCode=statusCode;
        this.statusMessage=statusMessage;
    }
    public static ResponseStatus getSuccessMessage() {
        return new ResponseStatus(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }



}
