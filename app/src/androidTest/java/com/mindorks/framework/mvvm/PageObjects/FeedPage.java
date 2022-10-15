package com.mindorks.framework.mvvm.PageObjects;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;


import android.view.View;

import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public class FeedPage {

    public static Matcher<View> toolbar = withId(R.id.toolbar);
    public static Matcher<View> blogTab = withText(R.string.blog);
    public static Matcher<View> opensourceTab = withText(R.string.open_source);
    public static Matcher<View> btnNavigateUp = withContentDescription(R.string.abc_action_bar_up_description);

    public static Matcher<View> rvOpensource = withId(R.id.openSourceRecyclerView);
    public static Matcher<View> loaderOpensource = withId(R.id.address_looking_up);

    public static Matcher<View> rvBlog = withId(R.id.blogRecyclerView);
    public static Matcher<View> loaderBlog = withId(R.id.address_looking_up);

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
