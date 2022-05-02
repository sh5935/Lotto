package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Random mRandom;
    private int[] mLotto = new int[6];
    private Button mButton;
    private TextView mTexView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTexView = findViewById(R.id.textView);
        mRandom = new Random();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<6; i++) {
                    do {
                        mLotto[i] = mRandom.nextInt(45) +1;
                    } while (isThereOverlap(i));
                }
                for (int i=0; i<mLotto.length-1; i++) {
                    for (int j=i+1; j<mLotto.length; j++) {
                        Log.d("Hosung.Kim", "i : " + i + ", j : " + j);
                        if (mLotto[i] > mLotto[j]) {
                            int temp = mLotto[i];
                            mLotto[i] = mLotto[j];
                            mLotto[j] = temp;
                        }

                    }
                }
                String mLottoStr = "";
                for (int i=0; i<6; i++) {
                    mLottoStr = mLottoStr + mLotto[i] + " ";
                }
                mTexView.setText(mLottoStr);
            }
        });
    }
    boolean isThereOverlap(int depth) {
        for (int i=0; i<depth; i++) {
            if (mLotto[depth] == mLotto[i]) {
                return true;
            }
        }
        return false;
    }
}

