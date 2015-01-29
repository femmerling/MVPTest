package com.emfeld.mvptest.listeners;

import android.view.View;

import com.emfeld.mvptest.presenters.interfaces.MainPresenter;

public class MainViewListener implements View.OnClickListener {

    private MainPresenter presenter;

    public MainViewListener(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onClick(View v) {
        presenter.validateForm();
    }
}
