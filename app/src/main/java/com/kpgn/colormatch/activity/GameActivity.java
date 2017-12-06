package com.kpgn.colormatch.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.constant.ApplicationConstant;
import com.kpgn.colormatch.utility.TextUtil;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends BaseActivity {

    @BindView(R.id.cta_restart)
    ImageView mRestart;

    @BindView(R.id.tv_counter)
    TextView mCounter;

    @BindView(R.id.tv_game_time)
    TextView mGameTime;

    @BindView(R.id.question_container)
    View mQuestionContainer;

    @BindView(R.id.img_answer_notification)
    ImageView mAnswerNotification;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);

        showGameStartTimerAndStartGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupQuestions() {
        toggleQuestionView(false);
        startGameTimer(ApplicationConstant.GAME_PLAY_TIME);
        getNewQuestion();
    }

    private void getNewQuestion() {
        //mAnswerNotification.setVisibility(View.INVISIBLE);
    }

    private void gameOver() {

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_restart)
    public void restartGame(View view) {
        showGameStartTimerAndStartGame();
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

    private void showGameStartTimerAndStartGame() {
        toggleQuestionView(true);
        mCounter.setText("3");
        mGameTime.setText(getString(R.string.formatted_time, "45"));
        cancelTimer();
        final Handler handler = new Handler();
        final AtomicInteger atomicInteger = new AtomicInteger(ApplicationConstant.COUNT_DOWN_TIMER);
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

    private void startGameTimer(long timerValue) {
        cancelTimer();
        countDownTimer = new CountDownTimer(timerValue, 1000) {
            public void onTick(long millisUntilFinished) {
                mGameTime.setText(getString(R.string.formatted_time, TextUtil.getFormattedTime(millisUntilFinished/1000)));
            }

            public void onFinish() {
                mGameTime.setText(getString(R.string.formatted_time, "00"));
                gameOver();
            }
        };
        countDownTimer.start();
    }

    private void cancelTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

}
