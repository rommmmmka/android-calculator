package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonSubtract;
    private Button buttonAdd;
    private Button buttonDecimal;
    private Button buttonPercent;
    private Button buttonClear;
    private Button buttonBackspace;
    private Button buttonEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        editText.setShowSoftInputOnFocus(false);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonClear = findViewById(R.id.buttonClear);
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonEquals = findViewById(R.id.buttonEquals);

        View.OnClickListener onClichBtn = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        addStr(getResources().getString(R.string.oneText));
                        break;
                    case R.id.button2:
                        addStr(getResources().getString(R.string.twoText));
                        break;
                    case R.id.button3:
                        addStr(getResources().getString(R.string.threeText));
                        break;
                    case R.id.button4:
                        addStr(getResources().getString(R.string.fourText));
                        break;
                    case R.id.button5:
                        addStr(getResources().getString(R.string.fiveText));
                        break;
                    case R.id.button6:
                        addStr(getResources().getString(R.string.sixText));
                        break;
                    case R.id.button7:
                        addStr(getResources().getString(R.string.sevenText));
                        break;
                    case R.id.button8:
                        addStr(getResources().getString(R.string.eightText));
                        break;
                    case R.id.button9:
                        addStr(getResources().getString(R.string.nineText));
                        break;
                    case R.id.button0:
                        addStr(getResources().getString(R.string.zeroText));
                        break;
                    case R.id.buttonDivide:
                        addStr(getResources().getString(R.string.divideText));
                        break;
                    case R.id.buttonMultiply:
                        addStr(getResources().getString(R.string.multiplyText));
                        break;
                    case R.id.buttonSubtract:
                        addStr(getResources().getString(R.string.subtractText));
                        break;
                    case R.id.buttonAdd:
                        addStr(getResources().getString(R.string.addText));
                        break;
                    case R.id.buttonDecimal:
                        btnDecimal();
                        break;
                    case R.id.buttonPercent:
                        btnPercent();
                        break;
                    case R.id.buttonClear:
                        btnClear();
                        break;
                    case R.id.buttonBackspace:
                        btnBackspace();
                        break;
                    case R.id.buttonEquals:
                        btnEquals();
                        break;
                }
            }
        };

        button1.setOnClickListener(onClichBtn);
        button2.setOnClickListener(onClichBtn);
        button3.setOnClickListener(onClichBtn);
        button4.setOnClickListener(onClichBtn);
        button5.setOnClickListener(onClichBtn);
        button6.setOnClickListener(onClichBtn);
        button7.setOnClickListener(onClichBtn);
        button8.setOnClickListener(onClichBtn);
        button9.setOnClickListener(onClichBtn);
        button0.setOnClickListener(onClichBtn);
        buttonDivide.setOnClickListener(onClichBtn);
        buttonMultiply.setOnClickListener(onClichBtn);
        buttonSubtract.setOnClickListener(onClichBtn);
        buttonAdd.setOnClickListener(onClichBtn);
        buttonDecimal.setOnClickListener(onClichBtn);
        buttonPercent.setOnClickListener(onClichBtn);
        buttonClear.setOnClickListener(onClichBtn);
        buttonBackspace.setOnClickListener(onClichBtn);
        buttonEquals.setOnClickListener(onClichBtn);
    }

    protected void addStr(String s) {
        StringBuilder expression = new StringBuilder(editText.getText());
        int cursorPos = editText.getSelectionStart();
        boolean changeSymbol = false;
        if (cursorPos != 0 && isSymbol(s.charAt(0)) && isSymbol(expression.charAt(cursorPos - 1))) {
            expression.replace(cursorPos - 1, cursorPos, s);
            changeSymbol = true;
        } else
            expression.insert(cursorPos, s);
        editText.setText(expression);
        if (changeSymbol)
            editText.setSelection(cursorPos);
        else
            editText.setSelection(cursorPos + s.length());
        getResult();
    }

    protected void btnDecimal() {
        StringBuilder expression = new StringBuilder(editText.getText());
        int cursorPos = editText.getSelectionStart();
        boolean foundPoint = false;
        for (int i = cursorPos - 1; i >= 0; i--) {
            if (expression.charAt(i) == getResources().getString(R.string.decimalText).charAt(0))
                foundPoint = true;
            if (!Character.isDigit(expression.charAt(i)))
                break;
        }
        for (int i = cursorPos; !foundPoint && i < expression.length(); i++) {
            if (expression.charAt(i) == getResources().getString(R.string.decimalText).charAt(0))
                foundPoint = true;
            if (!Character.isDigit(expression.charAt(i)))
                break;
        }
        if (foundPoint)
            return;
        String s = getResources().getString(R.string.decimalText);
        expression.insert(cursorPos, s);
        editText.setText(expression);
        editText.setSelection(cursorPos + s.length());
        getResult();
    }

    protected void btnPercent() {
        StringBuilder expression = new StringBuilder(editText.getText());
        expression.insert(0, "(");
        expression.append(")/100");
        editText.setText(expression);
        getResult();
    }

    private void btnClear() {
        editText.setText("");
        getResult();
    }

    private void btnBackspace() {
        int cursorPos = editText.getSelectionStart();
        if (cursorPos == 0)
            return;
        StringBuilder expression = new StringBuilder(editText.getText());
        expression.deleteCharAt(cursorPos - 1);
        editText.setText(expression);
        editText.setSelection(cursorPos - 1);
        getResult();
    }

    private void getResult() {
        String expression = String.valueOf(editText.getText());
        expression = expression.replaceAll(getResources().getString(R.string.divideText), "/");
        expression = expression.replaceAll(getResources().getString(R.string.multiplyText), "*");
        int bracketsCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(')
                bracketsCount++;
            if (expression.charAt(i) == ')')
                bracketsCount--;
        }
        StringBuilder expressionB = new StringBuilder(expression);
        while (expressionB.length() != 0 && !(Character.isDigit(expressionB.charAt(expressionB.length() - 1)))) {
            expressionB.deleteCharAt(expressionB.length() - 1);
        }
        if (expressionB.length() == 0)
            expressionB = new StringBuilder("0");
        Expression exp = new Expression(String.valueOf(expressionB));
        StringBuilder result = new StringBuilder(String.valueOf(exp.calculate()));
        result.insert(0, "=");
        if (result.length() >= 2 && result.charAt(result.length() - 2) == '.' && result.charAt(result.length() - 1) == '0')
            result.delete(result.length() - 2, result.length());
        textView.setText(result);
    }

    private void btnEquals() {
        StringBuilder result = new StringBuilder(String.valueOf(textView.getText()));
        result.deleteCharAt(0);
        editText.setText(result);
        editText.setSelection(result.length());
    }

    private boolean isSymbol(char c) {
        if (c == getResources().getString(R.string.divideText).charAt(0))
            return true;
        if (c == getResources().getString(R.string.multiplyText).charAt(0))
            return true;
        if (c == getResources().getString(R.string.subtractText).charAt(0))
            return true;
        if (c == getResources().getString(R.string.addText).charAt(0))
            return true;
        return false;
    }

}
