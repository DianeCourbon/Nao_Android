package com.naotictactoe.nao.views.event;

/**
 * Created by Diane on 07/11/2017.
 */

public class ErrorCodeEvent {
    private int errorCode;
    private String errorMsg;

    public ErrorCodeEvent(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
