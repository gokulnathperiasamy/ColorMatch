package com.kpgn.colormatch.activity;

import android.os.Bundle;

import com.kpgn.colormatch.R;

import butterknife.ButterKnife;

public class GameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);

        setupView();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupView() {

    }


}
