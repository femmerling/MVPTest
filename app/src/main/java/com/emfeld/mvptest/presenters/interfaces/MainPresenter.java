package com.emfeld.mvptest.presenters.interfaces;

import com.emfeld.mvptest.models.MainViewState;

public interface MainPresenter {
    public void onCreateView();
    public void validateForm();
    public MainViewState getState();
    public void onNameFieldChanged(String text);
    public void onEmailFieldChanged(String text);
    public void onPhoneFieldChanged(String text);
    public void onCompanyFieldChanged(String text);
}
