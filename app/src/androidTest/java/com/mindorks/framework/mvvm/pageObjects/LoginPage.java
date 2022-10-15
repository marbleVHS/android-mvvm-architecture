package com.mindorks.framework.mvvm.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import android.view.View;


import androidx.test.espresso.Espresso;

import com.mindorks.framework.mvvm.R;
import org.hamcrest.Matcher;

public final class LoginPage {

    public static Matcher<View> etEmail = withId(R.id.etEmail);

    public static Matcher<View> etPassword = withId(R.id.etPassword);

    public static Matcher<View> btnServerLogin = withId(R.id.btnServerLogin);

    public static Matcher<View> ibGoogleLogin = withId(R.id.ibGoogleLogin);

    public static Matcher<View> ibFbLogin = withId(R.id.ibFbLogin);

    public static void loginWithTestCredentials(){
        typeCredentials("sample@sample.com", "sample123");
        Espresso.closeSoftKeyboard();
        clickServerLogin();
    }

    public static void typeCredentials(String email, String password){
        onView(etEmail).perform(typeText(email));
        onView(etPassword).perform(typeText(password));
        Espresso.closeSoftKeyboard();
    }

    public static void clickGoogleLogin(){
        onView(ibGoogleLogin).perform(click());
    }

    public static void clickFbLogin(){
        onView(ibFbLogin).perform(click());
    }

    public static void clickServerLogin(){
        onView(btnServerLogin).perform(click());
    }


}