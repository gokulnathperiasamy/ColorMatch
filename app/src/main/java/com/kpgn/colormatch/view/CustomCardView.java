package com.kpgn.colormatch.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kpgn.colormatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomCardView extends LinearLayout {

    @BindView(R.id.tv_hint_text)
    TextView mHintText;

    @BindView(R.id.tv_text)
    TextView mText;

    public CustomCardView(Context context) {
        this(context, null);
    }

    public CustomCardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomCardView, 0, 0);
        String hintText = a.getString(R.styleable.CustomCardView_hintText);
        String text = a.getString(R.styleable.CustomCardView_text);
        int color = a.getColor(R.styleable.CustomCardView_textColor, -1);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_custom_card, this, true);
        }

        setHintText(hintText);
        setTextAndColor(text, color);
    }

    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        ButterKnife.bind(this, child.getRootView());
    }

    public void setHintText(String hintText) {
        mHintText.setText(hintText);
    }

    public void setTextAndColor(String text, int color) {
        mText.setText(text);
        mText.setTextColor(color);
    }

}