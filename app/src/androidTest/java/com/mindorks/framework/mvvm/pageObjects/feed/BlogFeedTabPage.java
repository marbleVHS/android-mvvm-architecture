package com.mindorks.framework.mvvm.pageObjects.feed;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.contrib.RecyclerViewActions;

import com.mindorks.framework.mvvm.R;

import org.hamcrest.Matcher;

public final class BlogFeedTabPage extends FeedTabPage {

    public static Matcher<View> rvBlog = withId(R.id.blogRecyclerView);

    public static void scrollToPosition(int position){
        onView(rvBlog).perform(RecyclerViewActions.scrollToPosition(position));
    }

}
