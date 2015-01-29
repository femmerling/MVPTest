package com.emfeld.mvptest.presenters.implementations;

import com.emfeld.mvptest.models.MainViewState;
import com.emfeld.mvptest.presenters.interfaces.MainPresenter;
import com.emfeld.mvptest.views.interfaces.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mView;
    private MainViewState mState;

    public MainPresenterImpl(MainView view) {
        mView = view;
        mState = new MainViewState();
    }

    @Override
    public void onCreateView() {
        mView.setUpView();
        mView.setUpListeners();

    }

    @Override
    public void validateForm() {
        if(formIsValid()){
            mView.displayResults();
        }
        else{
            mView.displayErrorToast();
        }
    }

    public boolean formIsValid(){
        if (mState.fullname == null || mState.email == null || mState.phone == null || mState.company == null){
            return false;
        }

        return true;
    }

    @Override
    public MainViewState getState() {
        return mState;
    }

    public void SetState(MainViewState state){
        mState = state;
    };

    @Override
    public void onNameFieldChanged(String text) {
        mState.fullname = text;
    }

    @Override
    public void onEmailFieldChanged(String text) {
        mState.email = text;
    }

    @Override
    public void onPhoneFieldChanged(String text) {
        mState.phone = text;
    }

    @Override
    public void onCompanyFieldChanged(String text) {
        mState.company = text;
    }
}
