package com.introvd.template.app.push.api.model;

public class CommonResponseResult<T> {
    public String code;
    public T data;
    public String message;
    public boolean status;
    public boolean success;
}
