package com.kpgn.colormatch.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.utility.DialogUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ButterKnife.bind(this);
        setupView();
    }

    private void setupView() {

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_restart_game)
    public void restartGame(View view) {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_info)
    public void showInfoDialog(View view) {
        DialogUtil.showAboutMessage(this);
    }
}
