package com.mindorks.framework.mvvm.customActions;

import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

public final class SetRating implements ViewAction {

    private int rating = 0;

    public SetRating(int rating){
        this.rating = rating;
    }

    @Override
    public Matcher<View> getConstraints() {
        Matcher <View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(RatingBar.class);
        return isRatingBarConstraint;
    }

    @Override
    public String getDescription() {
        return "Custom view action to set rating.";
    }

    @Override
    public void perform(UiController uiController, View view) {
        RatingBar ratingBar = (RatingBar) view;
        ratingBar.setRating(rating);
    }
}
