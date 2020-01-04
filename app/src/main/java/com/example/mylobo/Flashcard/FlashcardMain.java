package com.example.mylobo.Flashcard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylobo.HomeScreen;
import com.example.mylobo.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FlashcardMain extends AppCompatActivity {

    ImageView ivBackflashcard, add_card, delete_card, edit_card, next_card;
    TextView flashcard_question, flashcard_answer, timer;

    static int ADD_CARD_REQUEST_CODE = 0;
    static int EDIT_CARD_REQUEST_CODE = 1;
    int currentCardDisplayedIndex;

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;

    CountDownTimer countDownTimer;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        ivBackflashcard = findViewById(R.id.ivBackflashcard);
        flashcard_question = findViewById(R.id.flashcard_question);
        flashcard_answer = findViewById(R.id.flashcard_answer);
        edit_card = findViewById(R.id.edit_card);
        delete_card = findViewById(R.id.delete_card);
        add_card = findViewById(R.id.add_card);
        next_card = findViewById(R.id.next_card);
        timer = findViewById(R.id.timer);

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();
        currentCardDisplayedIndex = getRandomCardIndex();
        displayCard();

        //check if the database is empty or not
        if (allFlashcards != null && allFlashcards.size() > 0) {
            flashcard_question.setText(allFlashcards.get(0).getQuestion());
            flashcard_answer.setText(allFlashcards.get(0).getAnswer());
        }

        ivBackflashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashcardMain.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        flashcard_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View questionSideView = v;
                questionSideView.animate()
                        .rotationY(30).setDuration(100).withEndAction(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        questionSideView.setVisibility(View.INVISIBLE);
                                        findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                                        // second quarter turn
                                        findViewById(R.id.flashcard_answer).setRotationY(-30);
                                        findViewById(R.id.flashcard_answer).animate()
                                                .rotationY(0).setDuration(100).start();
                                    }
                                }
                        ).start();
            }
        });

        flashcard_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View answerSideView = v;
                answerSideView.animate()
                        .rotationY(30).setDuration(100).withEndAction(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        answerSideView.setVisibility(View.INVISIBLE);
                                        findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                                        // second quarter turn
                                        findViewById(R.id.flashcard_question).setRotationY(-30);
                                        findViewById(R.id.flashcard_question).animate()
                                                .rotationY(0).setDuration(100).start();
                                    }
                                }
                        ).start();
            }
        });

        add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashcardMain.this, AddCardActivity.class);
                FlashcardMain.this.startActivityForResult(intent, ADD_CARD_REQUEST_CODE);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        edit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(FlashcardMain.this, AddCardActivity.class);
                data.putExtra("question", ((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                data.putExtra("correct_answer", ((TextView) findViewById(R.id.flashcard_answer)).getText().toString());
                FlashcardMain.this.startActivityForResult(data, EDIT_CARD_REQUEST_CODE);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        next_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allFlashcards.size() == 1) {
                    Toast.makeText(FlashcardMain.this, "No more card. Press plus button to create more.", Toast.LENGTH_SHORT).show();
                } else {
                    currentCardDisplayedIndex = getRandomCardIndex();

                    final Animation rightInAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.right_in);
                    final Animation leftOutAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_out);
                    // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }

                    ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());

                    leftOutAnim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            displayCard();
                            findViewById(R.id.flashcard_question).startAnimation(rightInAnim);
                            findViewById(R.id.correct_answer).startAnimation(rightInAnim);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
            }
        });

        delete_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex = getRandomCardIndex();
                displayCard();
            }
        });

        countDownTimer = new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                Toast.makeText(FlashcardMain.this, "Time finished!", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_CARD_REQUEST_CODE || requestCode == EDIT_CARD_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String question = data.getExtras().getString("question");
                String correct_answer = data.getExtras().getString("correct_answer");
                if (requestCode == ADD_CARD_REQUEST_CODE) {
                    flashcardDatabase.insertCard(new Flashcard(question, correct_answer));
                    allFlashcards = flashcardDatabase.getAllCards();
                    currentCardDisplayedIndex = allFlashcards.size() - 1;
                    Snackbar.make(findViewById(R.id.flashcard_main), "Card successfully created", Snackbar.LENGTH_SHORT).show();
                }
                else if (requestCode == EDIT_CARD_REQUEST_CODE) {
                    flashcard_question.setText(question);
                    flashcard_answer.setText(correct_answer);
                    Snackbar.make(findViewById(R.id.flashcard_main), "Card successfully edited", Snackbar.LENGTH_SHORT).show();
                }
            }
            displayCard();
        }
    }

    //TODO: please review this code here
    private int getRandomCardIndex() {
        if (allFlashcards == null || allFlashcards.isEmpty())
            return -1;
        if (allFlashcards.size() == 1)
            return currentCardDisplayedIndex;
        while (true) {
            int x = (int) (Math.random() * allFlashcards.size());
            if (x != currentCardDisplayedIndex)
                return x;
        }
    }

    private void displayCard() {
        if (currentCardDisplayedIndex == -1) {
            findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            findViewById(R.id.emptystate).setVisibility(View.VISIBLE);
            findViewById(R.id.next_card).setVisibility(View.INVISIBLE);
            findViewById(R.id.edit_card).setVisibility(View.INVISIBLE);
            findViewById(R.id.delete_card).setVisibility(View.INVISIBLE);
        }
        else {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());

            findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
            findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            findViewById(R.id.emptystate).setVisibility(View.INVISIBLE);
            findViewById(R.id.next_card).setVisibility(View.VISIBLE);
            findViewById(R.id.edit_card).setVisibility(View.VISIBLE);
            findViewById(R.id.delete_card).setVisibility(View.VISIBLE);

//            startTimer();
        }
    }

    private void startTimer() {
        countDownTimer.cancel();
        countDownTimer.start();
    }
}
