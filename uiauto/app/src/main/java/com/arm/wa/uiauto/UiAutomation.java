package com.arm.wa.uiauto.calculator;

import android.app.Activity;
import android.os.Bundle;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.runner.AndroidJUnit4;

import android.util.Log;
import android.view.KeyEvent;

// Import the uiautomator libraries
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.arm.wa.uiauto.ApplaunchInterface;
import com.arm.wa.uiauto.BaseUiAutomation;
import com.arm.wa.uiauto.ActionLogger;
import com.arm.wa.uiauto.UiAutoUtils;

@RunWith(AndroidJUnit4.class)
public class UiAutomation extends BaseUiAutomation implements ApplaunchInterface {

    protected Bundle parameters;
    protected String packageID;
    protected int example_parameter;

    public static String TAG = "calculator";

    @Before
    public void initialize() throws Exception {
        // Perform any parameter initialization here
        parameters = getParams();
        packageID = getPackageID(parameters);
        example_parameter = parameters.getInt("example_parameter");
    }

    @Test
    public void setup() throws Exception {
        // Optional: Perform any setup required before the main workload
        // is ran, e.g. dismissing welcome screens
    }

    @Test
    public void runWorkload() throws Exception {
        // The main UI Automation code goes here
        UiObject digit =
            mDevice.findObject(new UiSelector().resourceId(packageID + "digit_8"));
        digit.click();
        UiObject op = mDevice.findObject(new UiSelector().resourceId(packageID + "op_add"));
        op.click();
        digit = mDevice.findObject(new UiSelector().resourceId(packageID + "digit_9"));
        digit.click();
        UiObject result = mDevice.findObject(new UiSelector().resourceId(packageID + "eq"));
        result.click();
    }

    @Test
    public void extractResults() throws Exception {
        // Optional: Extract any relevant results from the workload,
    }

    @Test
    public void teardown() throws Exception {
        // Optional: Perform any clean up for the workload
    }

    public void runApplicationSetup() throws Exception {
        // do nothing;
    }

    // Sets the UiObject that marks the end of the application launch.
    public UiObject getLaunchEndObject() {
        UiObject launchEndObject =
                        mDevice.findObject(new UiSelector().resourceId(packageID + "digit_8")
                                                           .className("android.widget.Button"));
        return launchEndObject;
    }

    // Returns the launch command for the application.
    public String getLaunchCommand() {
        String launch_command;
        launch_command = UiAutoUtils.createLaunchCommand(parameters);
        return launch_command;
    }

    // Pass the workload parameters, used for applaunch
    public void setWorkloadParameters(Bundle workload_parameters) {
        parameters = workload_parameters;
        packageID = getPackageID(parameters);
    }
}
