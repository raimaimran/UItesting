package com.example.presentation;

import android.app.Activity;

import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.runners.AndroidJUnit4; //for junit class
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class signInTest {


    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    //main activity defined in this class. Basically defining that all id's will be taken from this activity


    @Test //annotation = is important to add otherwise the defined test will not be performed
    public void email_entered() {
        onView(withId(R.id.bsemailid))
        .perform(typeText("raima.imran@gmail.com"));

        //on view, the component with the given id , we want to perform the following test
        //in our case the test is to check whether we can type text in the edit text view
    }

    @Test
    public void password_entered() {
        onView(withId(R.id.bspassword))
                .perform(typeText("password"));
    }

    @Test
    public void button_redirects_to_homepage(){
        onView(withId(R.id.bssignin)) //this checks whether button can be pressed, matches the button with id and clicks it
                .perform(click());
        onView(withId(R.id.homePage)) //second find the view displayed and checks whether it is displayed or not
                .check(matches(isDisplayed()));
    }

    @Test
    public void link_redirects_to_signup(){
        onView(withId(R.id.redirectsignup))
                .perform(click());

        onView(withId(R.id.signUp))
                .check(matches(isDisplayed()));
    }

}
