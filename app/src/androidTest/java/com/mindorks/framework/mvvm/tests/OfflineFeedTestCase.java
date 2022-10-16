package com.mindorks.framework.mvvm.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.pageObjects.feed.BlogFeedTabPage;
import com.mindorks.framework.mvvm.pageObjects.feed.FeedPage;
import com.mindorks.framework.mvvm.pageObjects.feed.OpenSourceFeedTabPage;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.flakinessSafety.FlakyActionExecutor;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class OfflineFeedTestCase {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Throwable {
        turnInternetOn();
        // navigating to Feed screen from entrypoint
        LoginPage.loginWithTestCredentials();
        turnInternetOff();
        MainPage.openDrawer();
        DrawerPage.openFeed();
    }

    @After
    public void tearDown() throws Throwable {
        turnInternetOn();
        FeedPage.navigateUp();
        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkOfflineBlogTab() throws Throwable {
        FeedPage.openBlogTab();
        onView(BlogFeedTabPage.ivEmpty).check(matches(isDisplayed()));
        onView(BlogFeedTabPage.tvMessage).check(matches(isDisplayed()));
        onView(BlogFeedTabPage.btnRetry).check(matches(isDisplayed()));
        turnInternetOn();
        BlogFeedTabPage.clickRetry();
        FlakyActionExecutor.checkOnView(BlogFeedTabPage.rvBlog, matches(hasDescendant(withId(R.id.coverImageView))));

    }

    @Test
    public void checkOfflineOpenSourceTab() throws Throwable {
        FeedPage.openOpensourceTab();
        onView(OpenSourceFeedTabPage.ivEmpty).check(matches(isDisplayed()));
        onView(OpenSourceFeedTabPage.tvMessage).check(matches(isDisplayed()));
        onView(OpenSourceFeedTabPage.btnRetry).check(matches(isDisplayed()));
        turnInternetOn();
        OpenSourceFeedTabPage.clickRetry();
        FlakyActionExecutor.checkOnView(OpenSourceFeedTabPage.rvOpensource, matches(hasDescendant(withId(R.id.coverImageView))));
    }

    private void turnInternetOn() throws InterruptedException {
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc wifi enable");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data enable");
        Thread.sleep(500L);
    }

    private void turnInternetOff() throws InterruptedException {
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc wifi disable");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("svc data disable");
        Thread.sleep(500L);
    }

}
