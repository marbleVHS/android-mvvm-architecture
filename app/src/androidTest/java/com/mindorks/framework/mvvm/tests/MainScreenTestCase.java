package com.mindorks.framework.mvvm.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.mindorks.framework.mvvm.pageObjects.DrawerPage;
import com.mindorks.framework.mvvm.pageObjects.LoginPage;
import com.mindorks.framework.mvvm.pageObjects.MainPage;
import com.mindorks.framework.mvvm.ui.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainScreenTestCase {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() {
        // navigating to MainScreen from entrypoint
        LoginPage.loginWithTestCredentials();
    }

    @After
    public void tearDown() throws Throwable {
        MainPage.openDrawer();
        DrawerPage.logout();
    }

    @Test
    public void checkActions(){
        onView(MainPage.actionCut).perform(click());
        onView(MainPage.actionCopy).perform(click());
        onView(MainPage.actionDelete).perform(click());
        onView(MainPage.actionShare).perform(click());
    }

    @Test
    public void checkDrawer() throws Throwable {
        MainPage.openDrawer();

        onView(DrawerPage.ivProfilePic).check(matches(isDisplayed()));
        onView(DrawerPage.tvEmail).check(matches(isDisplayed()));
        onView(DrawerPage.tvName).check(matches(isDisplayed()));

        MainPage.closeDrawer();
    }

    /**
     * Test with high flakiness.
     * Using IdlingResources might be a good idea, but i didn't want to change "production code".
     */
    @Test
    public void checkQuizCards() throws Throwable {
        MainPage.checkIfThereIsQuestion("What is the architecture of this app?");
        MainPage.clickOnAnswerButton("MVVM");
        MainPage.swipeCard();

        MainPage.checkIfThereIsQuestion("Which component of the MVVM controls the data flow?");
        MainPage.clickOnAnswerButton("Data Manager");
        MainPage.swipeCard();

        MainPage.checkIfThereIsQuestion("Why should we follow MVVM?");
        MainPage.clickOnAnswerButton("It is highly testable.");
        MainPage.swipeCard();

        MainPage.checkIfThereIsQuestion("Who is this person?");
        MainPage.clickOnAnswerButton("Linus Torvalds");
        MainPage.swipeCard();

        MainPage.checkIfThereIsQuestion("Which company's logo is this?");
        MainPage.clickOnAnswerButton("Mindorks");
        MainPage.swipeCard();
    }


}
