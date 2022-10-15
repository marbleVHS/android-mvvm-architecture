package com.mindorks.framework.mvvm.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import android.view.View;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginTestCase {
    private View decorView;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() {
        activityScenarioRule
                .getScenario()
                .onActivity(activity ->
                        decorView = activity.getWindow().getDecorView()
                );
    }

    @Test
    public void checkEmptyCredentialsToast() {
        onView(LoginPage.btnServerLogin).perform(click());

        onView(withText(R.string.invalid_email_password))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkInvalidCredentialsToast() {
        LoginPage.typeCredentials("NotAnEmail", "sample123");
        LoginPage.clickServerLogin();

        onView(withText(R.string.invalid_email_password))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkServerLogin() throws Throwable {
        LoginPage.typeCredentials("sample@sample.com", "sample123");
        LoginPage.clickServerLogin();

        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkGoogleLogin() throws Throwable {
        LoginPage.clickGoogleLogin();

        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkFbLogin() throws Throwable {
        LoginPage.clickFbLogin();

        MainPage.openDrawer();
        DrawerPage.logout();
    }

}
