package com.mindorks.framework.mvvm.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.mindorks.framework.mvvm.pageObjects.AboutPage;
import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AboutScreenTestCase {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Throwable {
        // navigating to About screen from entrypoint
        LoginPage.loginWithTestCredentials();
        MainPage.openDrawer();
        DrawerPage.openAbout();
    }

    @After
    public void tearDown() throws Throwable {
        AboutPage.navigateUp();
        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkTitle() {
        onView(AboutPage.toolbatText).check(matches(withText(R.string.about)));
    }

    @Test
    public void checkProjectInfo() {
        onView(AboutPage.txtHeading).check(matches(withText(R.string.project_info)));
    }

    @Test
    public void checkLinks() {
        onView(AboutPage.tvMindorksBlog).check(matches(hasLinks()));
        onView(AboutPage.tvMindorksRepo).check(matches(hasLinks()));
        onView(AboutPage.tvMvpBlog).check(matches(hasLinks()));
        onView(AboutPage.tvMvpRepo).check(matches(hasLinks()));
    }

}
