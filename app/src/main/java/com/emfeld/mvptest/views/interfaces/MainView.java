package com.emfeld.mvptest.views.interfaces;

import android.content.Context;

public interface MainView {
    public void displayResults();
    public void displayErrorToast();
    public void setUpView();
    public void setUpListeners();
    public Context getContext();
}
