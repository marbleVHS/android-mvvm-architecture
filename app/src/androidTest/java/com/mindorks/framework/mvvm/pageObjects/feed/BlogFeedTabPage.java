package com.mindorks.framework.mvvm.pageObjects.feed;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;

import android.view.View;

import androidx.test.espresso.contrib.RecyclerViewActions;

import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.flakinessSafety.FlakyActionExecutor;

import org.hamcrest.Matcher;

public final class BlogFeedTabPage {

    public static Matcher<View> rvBlog = withId(R.id.blogRecyclerView);

    public static Matcher<View> ivEmpty = allOf(withId(R.id.imageViewEmpty), withParent(withId(R.id.blogEmptyViewContainer)));
    public static Matcher<View> tvMessage = allOf(withId(R.id.tv_message), withParent(withId(R.id.blogEmptyViewContainer)));
    public static Matcher<View> btnRetry = allOf(withId(R.id.btn_retry), withParent(withId(R.id.blogEmptyViewContainer)));

    public static void clickRetry() throws Throwable {
        FlakyActionExecutor.actionOnView(btnRetry, click());
    }

    public static void scrollToPosition(int position){
        onView(rvBlog).perform(RecyclerViewActions.scrollToPosition(position));
    }

}
