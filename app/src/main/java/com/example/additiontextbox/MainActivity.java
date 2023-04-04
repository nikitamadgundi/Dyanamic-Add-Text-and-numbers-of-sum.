package com.example.additiontextbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mainContainerLayout;
    private ArrayList<EditText> list = new ArrayList<>();
    private Button btnAdd, btnMinus, btnSum, btnDifference;
    private TextView txtResult;

    ArrayList<Integer> numberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setupListener();

    }


    private void initViews() {

        mainContainerLayout = findViewById(R.id.mainContainerLayout);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnSum = findViewById(R.id.btnSum);
        btnDifference = findViewById(R.id.btnDiff);
    }

    private void setupListener() {
        btnAdd.setOnClickListener(new BtnOnClickListener());
        btnMinus.setOnClickListener(new BtnOnClickListener());
        btnSum.setOnClickListener(new BtnOnClickListener());
        btnDifference.setOnClickListener(new BtnOnClickListener());
    }

    private class BtnOnClickListener implements View.OnClickListener {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            EditText edt = new EditText(MainActivity.this);

            edt.setLayoutParams(layoutParams);

            edt.setHint("  EditText " + (list.size() + 1) + "  ");


            edt.setHintTextColor(Color.BLACK);
            edt.setBackgroundColor(R.color.black);

            edt.setTextColor(Color.BLACK);

            if (view == btnAdd) {
                list.add(edt);
                mainContainerLayout.addView(edt);

            } else if (view == btnMinus) {
                if (!list.isEmpty()) {
                    mainContainerLayout.removeView(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            } else if (view == btnSum) {
                numberList.clear();
                int addition = 0;
                for (int i = 0; i < list.size(); i++) {

                    if (!list.get(i).getText().toString().equals("")) {
                        numberList.add(Integer.valueOf(list.get(i).getText().toString()));
                    }
                }
                for (int i = 0; i < numberList.size(); i++) {
                    addition = addition + numberList.get(i);
                }
                txtResult.setText(String.valueOf(addition));
            } else if (view == btnDifference) {
                numberList.clear();
                int substraction = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).getText().toString().equals("")) {
                        numberList.add(Integer.valueOf(list.get(i).getText().toString()));
                    }
                }
                boolean isFirst = true;

                for (int i = 0; i < numberList.size(); i++) {

                    if(isFirst) {
                        isFirst = false;
                        substraction = substraction + numberList.get(i);
                    }
                    else {
                        substraction = substraction - numberList.get(i);
                    }


                }
                txtResult.setText(String.valueOf(substraction));
            }
        }
    }

}
