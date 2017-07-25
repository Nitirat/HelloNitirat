package com.oncelogs.hellonitirat;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Nitirat on 06-Apr-17.
 */

public class CustomViewGroup extends FrameLayout{

    private Button btnHello;

    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initinstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initinstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initinstances();
    }

    @TargetApi(21)
    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initinstances();
    }

    private void initInflate(){
        inflate(getContext(), R.layout.sample_layout, this);
    }

    private void initinstances() {
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }

    public void setBtnHello(String text){
        btnHello.setText(text);
    }

}
