package com.emfeld.mvptest.views.implementations;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emfeld.mvptest.R;
import com.emfeld.mvptest.listeners.MainViewListener;
import com.emfeld.mvptest.listeners.MainViewTextWatcher;
import com.emfeld.mvptest.presenters.interfaces.MainPresenter;
import com.emfeld.mvptest.presenters.implementations.MainPresenterImpl;
import com.emfeld.mvptest.views.interfaces.MainView;


public class MainActivity extends Activity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainPresenter presenter;
    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText companyEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        presenter.onCreateView();
        Log.d(TAG, "View Created");
    }

    @Override
    public void displayResults() {
        Toast.makeText(
                getApplicationContext(),getResources().getText(R.string.entry_valid_text),
                Toast.LENGTH_LONG)
             .show();
        Log.d(TAG, "Entry valid toast displayed");
    }

    @Override
    public void displayErrorToast() {
        Toast.makeText(
                getApplicationContext(),getResources().getText(R.string.entry_invalid_text),
                Toast.LENGTH_LONG)
             .show();
        Log.d(TAG, "Entry invalid toast displayed");
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setUpView() {
        fullNameEditText = (EditText) findViewById(R.id.full_name_edit_text);
        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        phoneEditText = (EditText) findViewById(R.id.phone_edit_text);
        companyEditText = (EditText) findViewById(R.id.company_edit_text);
        submitButton = (Button) findViewById(R.id.submit_button);
        Log.d(TAG, "View set up done");
    }

    @Override
    public void setUpListeners() {
        fullNameEditText.addTextChangedListener(new MainViewTextWatcher(fullNameEditText, presenter));
        emailEditText.addTextChangedListener(new MainViewTextWatcher(emailEditText,presenter));
        phoneEditText.addTextChangedListener(new MainViewTextWatcher(phoneEditText,presenter));
        companyEditText.addTextChangedListener(new MainViewTextWatcher(companyEditText,presenter));
        submitButton.setOnClickListener(new MainViewListener(presenter));
        Log.d(TAG, "View listener set up done");
    }
}
