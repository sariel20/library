package com.lc.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lc.lib.R;

/**
 * Created by LiangCheng on 2018/4/11.
 */

public class HeaderBar extends FrameLayout {

    private boolean isShowBack = true;
    private String titleText = "";
    private String rightText = "";

    ImageView mLeftIv;
    TextView mTitleTv;
    TextView mRightTv;

    public HeaderBar(@NonNull Context context) {
        super(context);
        initView();
    }

    public HeaderBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true);
        titleText = typedArray.getString(R.styleable.HeaderBar_titleText);
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText);
        typedArray.recycle();
        initView();
    }

    public HeaderBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = View.inflate(getContext(), R.layout.layout_header_bar, this);
        mLeftIv = view.findViewById(R.id.mLeftIv);
        mTitleTv = view.findViewById(R.id.mTitleTv);
        mRightTv = view.findViewById(R.id.mRightTv);

        if (isShowBack)
            mLeftIv.setVisibility(VISIBLE);
        else
            mLeftIv.setVisibility(INVISIBLE);

        if (!"".equals(titleText))
            mTitleTv.setText(titleText);

        if (!"".equals(rightText)) {
            mRightTv.setVisibility(VISIBLE);
            mRightTv.setText(rightText);
        }

    }


}
