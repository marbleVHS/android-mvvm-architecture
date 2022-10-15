package com.mindorks.framework.mvvm.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.DrawerMatchers;

import android.view.View;

import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.flakinessSafety.FlakyActionExecutor;

import org.hamcrest.Matcher;

public final class MainPage {

    public static Matcher<View> mDrawer = withId(R.id.drawerView);
    public static Matcher<View> mToolbar = withId(R.id.toolbar);
    public static Matcher<View> mNavigationView = withId(R.id.navigationView);
    public static Matcher<View> mCardsContainerView = withId(R.id.cardsContainer);
    public static Matcher<View> loader = withId(R.id.address_looking_up);

    public static Matcher<View> actionCut = withId(R.id.action_cut);
    public static Matcher<View> actionCopy = withId(R.id.action_copy);
    public static Matcher<View> actionDelete = withId(R.id.action_delete);
    public static Matcher<View> actionShare = withId(R.id.action_share);


    public static void openDrawer() throws Throwable {
        FlakyActionExecutor.actionOnView(mDrawer, DrawerActions.open());
        FlakyActionExecutor.checkOnView(mDrawer, matches(DrawerMatchers.isOpen()));
    }

    public static void closeDrawer() throws Throwable {
        FlakyActionExecutor.actionOnView(mDrawer, DrawerActions.close());
        FlakyActionExecutor.checkOnView(mDrawer, matches(DrawerMatchers.isClosed()));
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
