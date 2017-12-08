package com.kpgn.colormatch.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.utility.DialogUtil;
import com.kpgn.colormatch.utility.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_high_score)
    TextView mHighScore;

    @BindView(R.id.tv_max_cards)
    TextView mMaximumCards;

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
        mHighScore.setText(String.valueOf(PreferenceUtil.getHighScore(this)));
        mMaximumCards.setText(String.valueOf(PreferenceUtil.getMaximumCards(this)));
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_info)
    public void showInfoDialog(View view) {
        DialogUtil.showAboutMessage(this);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_start_game)
    public void startGame(View view) {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
