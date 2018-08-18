package com.diego.ovocacional.models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public  class Video {

    private final String text;
    private final String videoId;

    public Video(String text, String videoId) {
        this.text = text;
        this.videoId = videoId;
    }


    // Utility methods for layouting.

    private int dpToPx(int dp) {
      return 0;
       // return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

    private static void setLayoutSize(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    private static void setLayoutSizeAndGravity(View view, int width, int height, int gravity) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        params.gravity = gravity;
        view.setLayoutParams(params);
    }


}
