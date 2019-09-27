package com.introvd.template.common;

public interface ResultListener {
    void onError(Throwable th);

    void onSuccess(Object obj);
}
