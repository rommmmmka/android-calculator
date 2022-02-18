package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;

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
    private Button buttonParenthesesOpen;
    private Button buttonParenthesesClose;
    private Button buttonPower;
    private Button buttonE;
    private Button buttonPi;
    private Button buttonSin;
    private Button buttonCos;
    private Button buttonTg;
    private Button buttonLog;
    private Button buttonSquareRoot;

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
        buttonParenthesesOpen = findViewById(R.id.buttonParenthesesOpen);
        buttonParenthesesClose = findViewById(R.id.buttonParenthesesClose);
        buttonPower = findViewById(R.id.buttonPower);
        buttonE = findViewById(R.id.buttonE);
        buttonPi = findViewById(R.id.buttonPi);
        buttonSin = findViewById(R.id.buttonSin);
        buttonCos = findViewById(R.id.buttonCos);
        buttonTg = findViewById(R.id.buttonTg);
        buttonLog = findViewById(R.id.buttonLog);
        buttonSquareRoot = findViewById(R.id.buttonSquareRoot);

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
                    case R.id.buttonParenthesesOpen:
                        addStr(getResources().getString(R.string.parenthesesOpenText));
                        break;
                    case R.id.buttonParenthesesClose:
                        addStr(getResources().getString(R.string.parenthesesCloseText));
                        break;
                    case R.id.buttonPower:
                        addStr(getResources().getString(R.string.powerText));
                        break;
                    case R.id.buttonE:
                        addStr(getResources().getString(R.string.eText));
                        break;
                    case R.id.buttonPi:
                        addStr(getResources().getString(R.string.piText));
                        break;
                    case R.id.buttonSin:
                        addStr(getResources().getString(R.string.sinText));
                        break;
                    case R.id.buttonCos:
                        addStr(getResources().getString(R.string.cosText));
                        break;
                    case R.id.buttonTg:
                        addStr(getResources().getString(R.string.tgText));
                        break;
                    case R.id.buttonLog:
                        addStr(getResources().getString(R.string.logText));
                        break;
                    case R.id.buttonSquareRoot:
                        addStr(getResources().getString(R.string.squareRootText));
                        break;
                }
            }
        };

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                getResult();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

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
//        buttonParenthesesOpen.setOnClickListener(onClichBtn);
//        buttonParenthesesClose.setOnClickListener(onClichBtn);
//        buttonPower.setOnClickListener(onClichBtn);
//        buttonE.setOnClickListener(onClichBtn);
//        buttonPi.setOnClickListener(onClichBtn);
//        buttonSin.setOnClickListener(onClichBtn);
//        buttonCos.setOnClickListener(onClichBtn);
//        buttonTg.setOnClickListener(onClichBtn);
//        buttonLog.setOnClickListener(onClichBtn);
//        buttonSquareRoot.setOnClickListener(onClichBtn);
    }

    protected void addStr(String s) {
        StringBuilder expression = new StringBuilder(editText.getText());
        int cursorPos = editText.getSelectionStart();
        if (cursorPos != 0 && isSymbol(s.charAt(0)) && isSymbol(expression.charAt(cursorPos - 1))) {
            expression.replace(cursorPos - 1, cursorPos, s);
            editText.setText(expression);
            editText.setSelection(cursorPos);
            return;
        }
        if (isRequiresParentheses(s))
            s = new StringBuilder(s).append('(').toString();
        expression.insert(cursorPos, s);
        editText.setText(expression);
        editText.setSelection(cursorPos + s.length());
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
    }

    protected void btnPercent() {
        StringBuilder expression = new StringBuilder(editText.getText());
        expression.insert(0, "(");
        expression.append(")/100");
        editText.setText(expression);
        editText.setSelection(expression.length());
    }

    private void btnClear() {
        editText.setText("");
    }

    private void btnBackspace() {
        int cursorPos = editText.getSelectionStart();
        if (cursorPos == 0)
            return;
        StringBuilder expression = new StringBuilder(editText.getText());
        expression.deleteCharAt(cursorPos - 1);
        editText.setText(expression);
        editText.setSelection(cursorPos - 1);
    }

    private void getResult() {
        String expression = String.valueOf(editText.getText());
        expression = expression.replaceAll(getResources().getString(R.string.divideText), "/");
        expression = expression.replaceAll(getResources().getString(R.string.multiplyText), "*");
        StringBuilder expressionB = new StringBuilder(expression);
        while (expressionB.length() != 0 && !(Character.isDigit(expressionB.charAt(expressionB.length() - 1)))) {
            expressionB.deleteCharAt(expressionB.length() - 1);
        }
        int bracketsCount = 0;
        for (int i = 0; i < expressionB.length(); i++) {
            if (expressionB.charAt(i) == '(')
                bracketsCount++;
            if (expressionB.charAt(i) == ')')
                bracketsCount--;
        }
        for (; bracketsCount > 0; bracketsCount--)
            expressionB.append(')');
        if (expressionB.length() == 0)
            expressionB = new StringBuilder("0");
        Expression exp = new Expression(String.valueOf(expressionB));
        StringBuilder result = new StringBuilder(String.valueOf(exp.calculate()));
        result.insert(0, "=");
        if (result.charAt(result.length() - 2) == '.' && result.charAt(result.length() - 1) == '0')
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

    private boolean isRequiresParentheses(String s) {
        if (s.equals("sin"))
            return true;
        if (s.equals("cos"))
            return true;
        if (s.equals("tg"))
            return true;
        if (s.equals("log"))
            return true;
        return false;
    }
}
