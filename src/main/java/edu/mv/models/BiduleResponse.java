package edu.mv.models;

public class BiduleResponse {
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    private int httpStatusCode;
    private String message;

}
