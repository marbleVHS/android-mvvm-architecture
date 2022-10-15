package com.mindorks.framework.mvvm.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.pageObjects.RateUsDialogPage;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class RateUsTestCase {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Throwable {
        // navigating to Rate us dialog from entrypoint
        LoginPage.loginWithTestCredentials();
        MainPage.openDrawer();
        DrawerPage.openRateUs();
    }

    @After
    public void tearDown() throws Throwable {
        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkRatingBar(){
        RateUsDialogPage.setRating(1);
        RateUsDialogPage.setRating(2);
        RateUsDialogPage.setRating(3);
        RateUsDialogPage.setRating(4);
        RateUsDialogPage.setRating(5);
        RateUsDialogPage.submit();
    }

    @Test
    public void checkCancel(){
        RateUsDialogPage.cancel();
    }

}
