package com.mindorks.framework.mvvm.pageObjects.feed;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.contrib.RecyclerViewActions;

import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public final class OpenSourceFeedTabPage extends FeedTabPage {

    public static Matcher<View> rvOpensource = withId(R.id.openSourceRecyclerView);

    public static void scrollToPosition(int position){
        onView(rvOpensource).perform(RecyclerViewActions.scrollToPosition(position));
    }

}
