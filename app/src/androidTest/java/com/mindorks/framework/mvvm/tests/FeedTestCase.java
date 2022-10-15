package com.mindorks.framework.mvvm.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.feed.BlogFeedTabPage;
import com.mindorks.framework.mvvm.pageObjects.feed.FeedPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.pageObjects.feed.OpenSourceFeedTabPage;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class FeedTestCase {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Throwable {
        // navigating to Feed screen from entrypoint
        LoginPage.loginWithTestCredentials();
        MainPage.openDrawer();
        DrawerPage.openFeed();
    }

    @After
    public void tearDown() throws Throwable {
        FeedPage.navigateUp();
        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkBlogTab() {
        FeedPage.openBlogTab();
        onView(BlogFeedTabPage.rvBlog).check(matches(hasDescendant(withId(R.id.coverImageView))));
        BlogFeedTabPage.scrollToPosition(5);
        BlogFeedTabPage.scrollToPosition(0);
    }

    @Test
    public void checkOpenSourceTab() {
        FeedPage.openOpensourceTab();
        onView(OpenSourceFeedTabPage.rvOpensource).check(matches(hasDescendant(withId(R.id.coverImageView))));

        OpenSourceFeedTabPage.scrollToPosition(5);
        OpenSourceFeedTabPage.scrollToPosition(0);
    }

}
