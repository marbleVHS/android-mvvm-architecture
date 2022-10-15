package com.mindorks.framework.mvvm.pageObjects.feed;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;


import android.view.View;

import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public final class FeedPage {

    public static Matcher<View> toolbar = withId(R.id.toolbar);
    public static Matcher<View> blogTab = withText(R.string.blog);
    public static Matcher<View> opensourceTab = withText(R.string.open_source);
    public static Matcher<View> btnNavigateUp = withContentDescription(R.string.abc_action_bar_up_description);

    public static void navigateUp(){
        onView(btnNavigateUp).perform(click());
    }

    public static void openBlogTab(){
        onView(blogTab).perform(click());
    }

    public static void openOpensourceTab(){
        onView(opensourceTab).perform(click());
    }

}
