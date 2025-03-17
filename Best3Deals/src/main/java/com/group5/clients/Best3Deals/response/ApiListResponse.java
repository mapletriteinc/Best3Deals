package com.group5.clients.Best3Deals.response;

import java.util.List;

public class ApiListResponse<T> extends ApiResponse<List<T>> {
    // Constructor to initialize the response
    public ApiListResponse(boolean success, String message, List<T> data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    // Convenience constructor for success case
    public ApiListResponse(List<T> data) {
        this(true, "Success", data);
    }

    // Convenience constructor for error case
    public ApiListResponse(String errorMessage) {
        this(false, errorMessage, null);
    }
}