package com.maxui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class AwesomeTextView extends AppCompatTextView {

    private static final float DEFAULT_TEXTVIEW_CORNER = 4;
    private static final int DEFAULT_TEXTVIEW_BG_COLOR = R.attr.colorPrimary;
    private static final int DEFAULT_TEXTVIEW_STROKE_COLOR = R.attr.colorPrimary;
    private static final float DEFAULT_TEXTVIEW_STROKE_WIDTH = 0;

    @Dimension
    private float mCornerRadius = DEFAULT_TEXTVIEW_CORNER;

    private int mBGColor = DEFAULT_TEXTVIEW_BG_COLOR;

    private int mStrokeColor = DEFAULT_TEXTVIEW_STROKE_COLOR;

    @Dimension
    private float mStrokeWidth = DEFAULT_TEXTVIEW_STROKE_WIDTH;

    private GradientDrawable mDrawable = new GradientDrawable();

    public AwesomeTextView(Context context) {
        super(context);
        initMemberVariables(context, null);
    }

    public AwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMemberVariables(context, attrs);
    }

    private void initMemberVariables(@NonNull Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray mArray = context.obtainStyledAttributes(attrs, R.styleable.AwesomeTextView);
            mBGColor = mArray.getColor(R.styleable.AwesomeTextView_bgColor, DEFAULT_TEXTVIEW_BG_COLOR);
            mCornerRadius = mArray.getDimension(R.styleable.AwesomeTextView_corner, DEFAULT_TEXTVIEW_CORNER);
            mStrokeWidth = mArray.getDimension(R.styleable.AwesomeTextView_strokeWidth, DEFAULT_TEXTVIEW_STROKE_WIDTH);
            mStrokeColor = mArray.getColor(R.styleable.AwesomeTextView_strokeColor, DEFAULT_TEXTVIEW_STROKE_COLOR);
            mArray.recycle();
        }

        setTextViewDrawable();
    }

    public float getCornerRadius() {
        return mCornerRadius;
    }

    public void setCornerRadius(float mCornerRadius) {
        this.mCornerRadius = mCornerRadius;
        setTextViewDrawable();
    }

    public int getBGColor() {
        return mBGColor;
    }

    public void setBGColor(@ColorRes int mBGColor) {
        this.mBGColor =  ContextCompat.getColor(getContext(), mBGColor);
        setTextViewDrawable();
    }

    public int getStrokeColor() {
        return mStrokeColor;
    }

    public void setStrokeColor(@ColorRes int mStrokeColor) {
        this.mStrokeColor = ContextCompat.getColor(getContext(), mStrokeColor);
        setTextViewDrawable();
    }

    public float getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(float mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
        setTextViewDrawable();
    }

    private void setTextViewDrawable() {
        mDrawable.setColor(mBGColor);
        mDrawable.setCornerRadius(mCornerRadius);
        mDrawable.setStroke((int) mStrokeWidth, mStrokeColor);

        setBackground(mDrawable);
    }
}
