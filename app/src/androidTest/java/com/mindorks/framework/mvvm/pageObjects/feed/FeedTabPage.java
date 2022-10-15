package com.mindorks.framework.mvvm.pageObjects.feed;

import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.flakinessSafety.FlakyActionExecutor;

import org.hamcrest.Matcher;

class FeedTabPage {

    public static Matcher<View> loader = withId(R.id.address_looking_up);

    public static Matcher<View> ivEmpty = withId(R.id.imageViewEmpty);
    public static Matcher<View> tvMessage = withId(R.id.tv_message);
    public static Matcher<View> btnRetry = withId(R.id.btn_retry);

    public static void clickRetry() throws Throwable {
        FlakyActionExecutor.actionOnView(btnRetry, click());
    }

}
