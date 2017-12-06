package com.kpgn.colormatch.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.constant.ApplicationConstant;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends BaseActivity {

    @BindView(R.id.cta_restart)
    ImageView mRestart;

    @BindView(R.id.tv_counter)
    TextView mCounter;

    @BindView(R.id.question_container)
    View mQuestionContainer;

    @BindView(R.id.img_answer_notification)
    ImageView mAnswerNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);

        showTimerAndStartGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void showTimerAndStartGame() {
        toggleQuestionView(true);
        mCounter.setText("3");
        final Handler handler = new Handler();
        final AtomicInteger atomicInteger = new AtomicInteger(ApplicationConstant.TIMER_COUNT);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                mCounter.setText(Integer.toString(atomicInteger.get()));
                if (atomicInteger.getAndDecrement() >= 1)
                    handler.postDelayed(this, ApplicationConstant.MILLI_SECOND);
                else {
                    setupQuestions();
                }
            }
        };
        handler.postDelayed(counter, ApplicationConstant.MILLI_SECOND);
    }

    private void setupQuestions() {
        toggleQuestionView(false);
        getNewQuestion();
    }

    private void getNewQuestion() {
        //mAnswerNotification.setVisibility(View.INVISIBLE);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_restart)
    public void restartGame(View view) {
        showTimerAndStartGame();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_yes)
    public void optionYes(View view) {
        toggleAnswerNotification(true);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_no)
    public void optionNo(View view) {
        toggleAnswerNotification(false);
    }

    private void toggleQuestionView(boolean isHidden) {
        if (isHidden) {
            mCounter.setVisibility(View.VISIBLE);
            mRestart.setVisibility(View.GONE);
            mQuestionContainer.setVisibility(View.GONE);
            mAnswerNotification.setVisibility(View.INVISIBLE);
        } else {
            mCounter.setVisibility(View.GONE);
            mRestart.setVisibility(View.VISIBLE);
            mQuestionContainer.setVisibility(View.VISIBLE);
        }
    }

    private void toggleAnswerNotification(boolean isCorrect) {
        mAnswerNotification.setVisibility(View.VISIBLE);
        if (isCorrect) {
            mAnswerNotification.setImageDrawable(getResources().getDrawable(R.drawable.ic_correct));
        } else {
            mAnswerNotification.setImageDrawable(getResources().getDrawable(R.drawable.ic_wrong));
        }
    }

}
