package com.mindorks.framework.mvvm.PageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.contrib.DrawerActions;

import android.view.View;

import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.flakinessSafety.FlakyActionExecutor;

import org.hamcrest.Matcher;

public class MainPage {

    public static Matcher<View> mDrawer = withId(R.id.drawerView);
    public static Matcher<View> mToolbar = withId(R.id.toolbar);
    public static Matcher<View> mNavigationView = withId(R.id.navigationView);
    public static Matcher<View> mCardsContainerView = withId(R.id.cardsContainer);
    public static Matcher<View> loader = withId(R.id.address_looking_up);


    public static void openDrawer() throws Throwable {
        FlakyActionExecutor.actionOnView(MainPage.mDrawer, DrawerActions.open());
    }

    public static void closeDrawer() throws Throwable {
        FlakyActionExecutor.actionOnView(MainPage.mDrawer, DrawerActions.close());
    }

    public static void checkIfThereIsQuestion(String questionText) throws Throwable {
        FlakyActionExecutor.checkOnView(
                withText(questionText),
                matches(isDisplayed())
        );
    }

    public static void clickOnAnswerButton(String answerText) throws Throwable {
        FlakyActionExecutor.actionOnView(withText(answerText), click());
    }

    public static void swipeCard(){
        onView(mCardsContainerView).perform(swipeLeft());
    }

}
