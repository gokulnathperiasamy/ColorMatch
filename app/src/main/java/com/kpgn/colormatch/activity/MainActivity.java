package com.kpgn.colormatch.activity;

import android.os.Bundle;
import android.view.View;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.utility.DialogUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_info)
    public void showInfoDialog(View view) {
        DialogUtil.showAboutMessage(this);
    }
}
