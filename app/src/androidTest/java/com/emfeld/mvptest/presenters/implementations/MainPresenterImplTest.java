package com.emfeld.mvptest.presenters.implementations;

import com.emfeld.mvptest.models.MainViewState;
import com.emfeld.mvptest.views.implementations.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class MainPresenterImplTest {

    private MainPresenterImpl presenter;
    private MainViewState state;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenterImpl(Mockito.mock(MainActivity.class));
    }

    @After
    public void tearDown() throws Exception {
        presenter = null;
    }

    @Test
    public void testValidateFormEmpty() throws Exception{
        assertFalse(presenter.formIsValid());
    }

    @Test
    public void testValidateFormNameEmpty() throws Exception{
        presenter.onEmailFieldChanged("someguy@mail.com");
        presenter.onPhoneFieldChanged("+621234567890");
        presenter.onCompanyFieldChanged("Some Company");
        assertFalse(presenter.formIsValid());
    }

    @Test
    public void testValidateFormEmailEmpty() throws Exception{
        presenter.onNameFieldChanged("Some Guy");
        presenter.onPhoneFieldChanged("+621234567890");
        presenter.onCompanyFieldChanged("Some Company");
        assertFalse(presenter.formIsValid());
    }

    @Test
    public void testValidateFormPhoneEmpty() throws Exception{
        presenter.onNameFieldChanged("Some Guy");
        presenter.onEmailFieldChanged("someguy@mail.com");
        presenter.onCompanyFieldChanged("Some Company");
        assertFalse(presenter.formIsValid());
    }

    @Test
    public void testValidateFormCompanyEmpty() throws Exception{
        presenter.onNameFieldChanged("Some Guy");
        presenter.onEmailFieldChanged("someguy@mail.com");
        presenter.onPhoneFieldChanged("+621234567890");
        assertFalse(presenter.formIsValid());
    }

    @Test
    public void testValidateFormSuccess() throws Exception{
        presenter.onNameFieldChanged("Some Guy");
        presenter.onEmailFieldChanged("someguy@mail.com");
        presenter.onPhoneFieldChanged("+621234567890");
        presenter.onCompanyFieldChanged("Some Company");
        assertTrue(presenter.formIsValid());
    }

    @Test
    public void testNameFieldChanged() throws Exception{
        String testString = "Some Guy";
        presenter.onNameFieldChanged(testString);
        assertEquals(testString, presenter.getState().fullname);
    }

    @Test
    public void testEmailFieldChanged() throws Exception{
        String testString = "someguy@mail.com";
        presenter.onEmailFieldChanged(testString);
        assertEquals(testString, presenter.getState().email);
    }

    @Test
    public void testPhoneFieldChanged() throws Exception{
        String testString = "+621234567890";
        presenter.onPhoneFieldChanged(testString);
        assertEquals(testString, presenter.getState().phone);
    }

    @Test
    public void testCompanyFieldChanged() throws Exception{
        String testString = "Some Company";
        presenter.onCompanyFieldChanged(testString);
        assertEquals(testString, presenter.getState().company);
    }

}