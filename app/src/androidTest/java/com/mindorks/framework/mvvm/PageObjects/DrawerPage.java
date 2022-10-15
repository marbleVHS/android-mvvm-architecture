package com.mindorks.framework.mvvm.PageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.view.View;


import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public class DrawerPage {

    public static Matcher<View> ivProfilePic = withId(R.id.iv_profile_pic);
    public static Matcher<View> tvName = withId(R.id.tv_name);
    public static Matcher<View> tvEmail = withId(R.id.tv_email);

    public static Matcher<View> niAbout = withText(R.string.about);
    public static Matcher<View> niRateUs = withText(R.string.rate_us);
    public static Matcher<View> niFeed = withText(R.string.feed);
    public static Matcher<View> niLogout = withText(R.string.logout);

    public static void openAbout(){ onView(niAbout).perform(click()); }
    public static void openRateUs(){ onView(niRateUs).perform(click()); }
    public static void openFeed(){ onView(niFeed).perform(click()); }
    public static void logout(){ onView(niLogout).perform(click()); }

}
