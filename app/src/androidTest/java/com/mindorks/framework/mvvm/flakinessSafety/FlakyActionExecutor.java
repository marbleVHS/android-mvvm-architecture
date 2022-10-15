package com.mindorks.framework.mvvm.flakinessSafety;

import static androidx.test.espresso.Espresso.onView;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Matcher;

public class FlakyActionExecutor {


    public static void actionOnView(Matcher<View> viewMatcher, ViewAction viewAction) throws Throwable {
        Throwable exception = null;
        boolean operationResult;
        long startTime = SystemClock.elapsedRealtime();
        long endTime = startTime + ViewActionsConfig.ACTION_TIMEOUT;
        do {
            operationResult = true;
            try {
                onView(viewMatcher).perform(viewAction);
            } catch (PerformException error) {
                operationResult = false;
                exception = error;
            } catch (NoMatchingViewException error) {
                operationResult = false;
                exception = error;
            }
            if (!operationResult) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (SystemClock.elapsedRealtime() < endTime && !operationResult);
        if (!operationResult) {
            throw exception;
        }
    }

    public static void checkOnView(Matcher<View> viewMatcher, ViewAssertion viewAssertion) throws Throwable{
        Throwable exception = null;
        boolean operationResult;
        long startTime = SystemClock.elapsedRealtime();
        long endTime = startTime + ViewActionsConfig.ACTION_TIMEOUT;
        do {
            operationResult = true;
            try {
                onView(viewMatcher).check(viewAssertion);
            } catch (AssertionError error) {
                operationResult = false;
                exception = error;
            } catch (NoMatchingViewException error) {
                operationResult = false;
                exception = error;
            }
            if (!operationResult) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (SystemClock.elapsedRealtime() < endTime && !operationResult);
        if (!operationResult) {
            throw exception;
        }
    }

}

