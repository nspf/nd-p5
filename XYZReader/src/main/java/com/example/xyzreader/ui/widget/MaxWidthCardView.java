/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.xyzreader.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * A simple {@link LinearLayout} subclass that has a maxWidth
 */
public class MaxWidthCardView extends CardView {
    private static final int[] ATTRS = {
            android.R.attr.maxWidth
    };

    private int mMaxWidth = Integer.MAX_VALUE;

    public MaxWidthCardView(Context context) {
        super(context);

    }

    public MaxWidthCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaxWidthCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }


    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        mMaxWidth = a.getLayoutDimension(0, Integer.MAX_VALUE);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newSpecWidth = Math.min(MeasureSpec.getSize(widthMeasureSpec), mMaxWidth);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(newSpecWidth, MeasureSpec.getMode(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}