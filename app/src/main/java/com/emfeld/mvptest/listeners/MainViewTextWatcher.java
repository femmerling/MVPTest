package com.emfeld.mvptest.listeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.emfeld.mvptest.R;
import com.emfeld.mvptest.presenters.interfaces.MainPresenter;

/**
 * Created by fauzan@traveloka.com on 1/29/15.
 */
public class MainViewTextWatcher implements TextWatcher {

    private View mView;
    private MainPresenter mPresenter;

    public MainViewTextWatcher(View view, MainPresenter presenter){
        mView = view;
        mPresenter = presenter;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable editedString) {
        String text = editedString.toString();
        switch(mView.getId()){
            case R.id.full_name_edit_text:
                mPresenter.onNameFieldChanged(text);
                break;
            case R.id.email_edit_text:
                mPresenter.onEmailFieldChanged(text);
                break;
            case R.id.phone_edit_text:
                mPresenter.onPhoneFieldChanged(text);
                break;
            case R.id.company_edit_text:
                mPresenter.onCompanyFieldChanged(text);
                break;
        }
    }
}
