package com.mindorks.framework.mvvm.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.view.View;

import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public final class AboutPage {

    public static Matcher<View> toolbar = withId(R.id.toolbar);
    public static Matcher<View> navBackBtn = withId(R.id.navBackBtn);
    public static Matcher<View> toolbatText = withId(R.id.toolbarText);
    public static Matcher<View> txtHeading = withId(R.id.txt_heading);
    public static Matcher<View> tvMvpBlog = withId(R.id.tvMvpBlog);
    public static Matcher<View> tvMvpRepo = withId(R.id.tvMvpRepo);
    public static Matcher<View> tvMindorksBlog = withId(R.id.tvMindorksBlog);
    public static Matcher<View> tvMindorksRepo = withId(R.id.tvMindorksRepo);

    public static void navigateUp(){
        onView(navBackBtn).perform(click());
    }

}
