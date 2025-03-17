package com.group5.clients.Best3Deals.response;

public class ApiVoidResponse extends ApiResponse<Void> {
    // Constructor to initialize the response
    public ApiVoidResponse(boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(null); // No data for void responses
    }

    // Convenience constructor for success case
    public ApiVoidResponse() {
        this(true, "Operation completed successfully");
    }

    // Convenience constructor for error case
    public ApiVoidResponse(String errorMessage) {
        this(false, errorMessage);
    }
}