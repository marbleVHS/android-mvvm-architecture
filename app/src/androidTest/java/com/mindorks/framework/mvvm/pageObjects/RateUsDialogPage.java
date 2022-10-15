package com.mindorks.framework.mvvm.pageObjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.view.View;

import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.customActions.SetRating;

import org.hamcrest.Matcher;

public final class RateUsDialogPage {

    public static Matcher<View> tvRateUsTitle = withId(R.id.tvRateUsTitle);
    public static Matcher<View> ratingBar = withId(R.id.ratingBarFeedback);
    public static Matcher<View> btnLater = withId(R.id.btnLater);
    public static Matcher<View> btnSubmit = withId(R.id.btnSubmit);

    public static void setRating(int rating){
        onView(ratingBar).perform(new SetRating(rating));
    }

    public static void submit(){
        onView(btnSubmit).perform(click());
    }

    public static void cancel(){
        onView(btnLater).perform(click());
    }

}
