package com.introvd.template.common.controller;

import com.introvd.template.common.controller.MvpView;

public abstract class BaseController<T extends MvpView> {
    private T ceF;

    public void attachView(T t) {
        this.ceF = t;
    }

    public void detachView() {
        this.ceF = null;
    }

    public T getMvpView() {
        return this.ceF;
    }
}
