package com.iuhaynad.java_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // object declaration
    TextView previousCalculation;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // object initialization
        previousCalculation = findViewById(R.id.previousCalculation_view);
        display = findViewById(R.id.displayEditText_view);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String addition) {
        String sourceExpression = display.getText().toString();

        // cursor
        int cursorPosition = display.getSelectionStart();
        String left = sourceExpression.substring(0, cursorPosition),
                right = sourceExpression.substring(cursorPosition);

        display.setText(String.format("%s%s%s", left, addition, right));
        display.setSelection(cursorPosition + addition.length());
    }

    // numbers
    public void zero_btn_push(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void one_btn_push(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void two_btn_push(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void three_btn_push(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void four_btn_push(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void five_btn_push(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void six_btn_push(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void seven_btn_push(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eight_btn_push(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nine_btn_push(View view){
        updateText(getResources().getString(R.string.nineText));
    }

    // bonus symbols
    public void dot_btn_push(View view){
        updateText(getResources().getString(R.string.dotText));
    }
    public void openParenthesis_btn_push(View view){
        updateText(getResources().getString(R.string.openParenthesisText));
    }
    public void closeParenthesis_btn_push(View view){
        updateText(getResources().getString(R.string.closeParenthesisText));
    }

    // main operations
    public void divide_btn_push(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void multiply_btn_push(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void subtract_btn_push(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void add_btn_push(View view){
        updateText(getResources().getString(R.string.addText));
    }

    // cleaning
    public void backspace_btn_push(View view) {
        int cursorPosition = display.getSelectionStart();
        int textLength = display.getText().length();

        if (cursorPosition != 0 && textLength != 0) {
            SpannableStringBuilder selection =
                    (SpannableStringBuilder) display.getText();
            selection.replace(cursorPosition - 1,
                    cursorPosition, "");
            display.setText(selection);
            display.setSelection(cursorPosition - 1);
        }
    }
    public void clear_btn_push(View view){
        display.setText("");
        previousCalculation.setText("");
    }

    // getting result
    public void equal_btn_push(View view){
        updateText(getResources().getString(R.string.addText));
    }
}