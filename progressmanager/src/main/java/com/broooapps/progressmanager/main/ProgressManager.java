package com.broooapps.progressmanager.main;

import android.content.Context;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Swapnil Tiwari on 2019-05-07.
 * swapnil.tiwari@box8.in
 */
public class ProgressManager {

    ArrayList<View> progressList;
    WeakReference<Context> contextWeakReference;

    private ProgressManager() {
    }

    private ProgressManager(Context context) {
        progressList = new ArrayList<>();
        contextWeakReference = new WeakReference<>(context);
    }

    public static ProgressManager of(Context context) {
        return new ProgressManager(context);
    }

    public void addProgressView(final View view) {
        progressList.add(view);
    }

    public void hideProgress(final View view) {
        for (View v : progressList) {
            if (v.equals(view)) {
                v.setVisibility(View.GONE);
            }
        }
    }

    public void hideAllProgress() {
        for (View v : progressList) {
            v.setVisibility(View.GONE);
        }
    }

    public void showAllProgress() {
        for (View v : progressList) {
            v.setVisibility(View.VISIBLE);
        }
    }
}
