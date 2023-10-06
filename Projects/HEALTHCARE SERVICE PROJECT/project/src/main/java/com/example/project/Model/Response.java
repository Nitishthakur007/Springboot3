package com.example.project.Model;

public class Response {
    private String message;
    private String token;
    private  String id;

    public Response() {
    }

    public Response(String message, String token, String id) {
        this.message = message;
        this.token = token;
        this.id = id;
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
