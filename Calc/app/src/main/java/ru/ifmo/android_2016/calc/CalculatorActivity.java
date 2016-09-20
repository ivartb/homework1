package ru.ifmo.android_2016.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTextView;
    Button d0Button;
    Button d1Button;
    Button d2Button;
    Button d3Button;
    Button d4Button;
    Button d5Button;
    Button d6Button;
    Button d7Button;
    Button d8Button;
    Button d9Button;
    Button eqvButton;
    Button divButton;
    Button mulButton;
    Button subButton;
    Button addButton;
    Button clearButton;

    StringBuilder text = new StringBuilder();
    int num1 = 0;
    int num2 = 0;
    char action = '0';

    private static final String KEY_ACTION = "action_char";
    private static final String KEY_RESULT = "result_text";
    private static final String KEY_NUM1 = "num1";
    private static final String KEY_NUM2 = "num2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        d0Button = (Button) findViewById(R.id.d0);
        d1Button = (Button) findViewById(R.id.d1);
        d2Button = (Button) findViewById(R.id.d2);
        d3Button = (Button) findViewById(R.id.d3);
        d4Button = (Button) findViewById(R.id.d4);
        d5Button = (Button) findViewById(R.id.d5);
        d6Button = (Button) findViewById(R.id.d6);
        d7Button = (Button) findViewById(R.id.d7);
        d8Button = (Button) findViewById(R.id.d8);
        d9Button = (Button) findViewById(R.id.d9);
        eqvButton = (Button) findViewById(R.id.eqv);
        divButton = (Button) findViewById(R.id.div);
        mulButton = (Button) findViewById(R.id.mul);
        subButton = (Button) findViewById(R.id.sub);
        addButton = (Button) findViewById(R.id.add);
        clearButton = (Button) findViewById(R.id.clear);
        resultTextView = (TextView) findViewById(R.id.result);

        d0Button.setOnClickListener(this);
        d1Button.setOnClickListener(this);
        d2Button.setOnClickListener(this);
        d3Button.setOnClickListener(this);
        d4Button.setOnClickListener(this);
        d5Button.setOnClickListener(this);
        d6Button.setOnClickListener(this);
        d7Button.setOnClickListener(this);
        d8Button.setOnClickListener(this);
        d9Button.setOnClickListener(this);
        eqvButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        if (savedInstanceState != null) {
            text.replace(0, text.length(), savedInstanceState.getString(KEY_RESULT));
            resultTextView.setText(text);
            action = savedInstanceState.getChar(KEY_ACTION);
            num1 = savedInstanceState.getInt(KEY_NUM1);
            num2 = savedInstanceState.getInt(KEY_NUM2);
        }
    }

    private void addNum2Digit(int digit) {
        text.append(Integer.toString(digit));
        if (action != '0')
            num2 = num2 * 10 + digit;
    }

    private void setText(char ch) {
        num2 = 0;
        text.delete(0, text.length());
        text.append(num1).append(ch);
        action = ch;
    }

    private void addAction(char ch) {
        num1 = num1 + num2;
        setText(ch);
    }

    private void subAction(char ch) {
        num1 = num1 - num2;
        setText(ch);
    }

    private void mulAction(char ch) {
        num1 = num1 * num2;
        setText(ch);
    }

    private void divAction(char ch) {
        if (num2 != 0) {
            num1 = num1 / num2;
            setText(ch);
        }
        else {
            text.replace(0, text.length(), "ERROR");
            action = '0';
            num1 = 0;
            num2 = 0;
        }
    }

    private void noAction(char ch) {
        if (TextUtils.isEmpty(text))
            num1 = 0;
        else
            num1 = Integer.parseInt(text.toString());
        setText(ch);
    }

    @Override
    public void onClick(View v) {
            if (v == d0Button) {
                addNum2Digit(0);
            }
            else if (v == d1Button) {
                addNum2Digit(1);
            }
            else if (v == d2Button) {
                addNum2Digit(2);
            }
            else if (v == d3Button) {
                addNum2Digit(3);
            }
            else if (v == d4Button) {
                addNum2Digit(4);
            }
            else if (v == d5Button) {
                addNum2Digit(5);
            }
            else if (v == d6Button) {
                addNum2Digit(6);
            }
            else if (v == d7Button) {
                addNum2Digit(7);
            }
            else if (v == d8Button) {
                addNum2Digit(8);
            }
            else if (v == d9Button) {
                addNum2Digit(9);
            }

        else if (v == clearButton) {
            text.delete(0, text.length());
            num1 = 0;
            num2 = 0;
            action = '0';
        }

        else if (v == eqvButton) {
            switch (action) {
                case '+': {
                    num1 = num1 + num2;
                    break;
                }
                case '-': {
                    num1 = num1 - num2;
                    break;
                }
                case '*': {
                    num1 = num1 * num2;
                    break;
                }
                case '/': {
                    if (num2 != 0)
                        num1 = num1 / num2;
                    else {
                        text.replace(0, text.length(), "ERROR");
                        action = '0';
                        num1 = 0;
                        num2 = 0;
                        resultTextView.setText(text);
                        return;
                    }
                    break;
                }
                case '0': {
                    break;
                }
            }
            num2 = 0;
            text.delete(0, text.length());
            text.append(num1);
            action = '0';
        }

        else if (v == addButton) {
             switch (action) {
                    case '+': {
                        addAction('+');
                        break;
                    }
                    case '-': {
                        subAction('+');
                        break;
                    }
                    case '*': {
                        mulAction('+');
                        break;
                    }
                    case '/': {
                        divAction('+');
                        break;
                    }
                    case '0': {
                        noAction('+');
                        break;
                    }
             }
        }
        else if (v == subButton) {
            switch (action) {
                case '+': {
                    addAction('-');
                    break;
                }
                case '-': {
                    subAction('-');
                    break;
                }
                case '*': {
                    mulAction('-');
                    break;
                }
                case '/': {
                    divAction('-');
                    break;
                }
                case '0': {
                    noAction('-');
                    break;
                }
            }
        }
        else if (v == mulButton) {
            switch (action) {
                case '+': {
                    addAction('*');
                    break;
                }
                case '-': {
                    subAction('*');
                    break;
                }
                case '*': {
                    mulAction('*');
                    break;
                }
                case '/': {
                    divAction('*');
                    break;
                }
                case '0': {
                    noAction('*');
                    break;
                }
            }
        }
        else if (v == divButton) {
            switch (action) {
                case '+': {
                    addAction('/');
                    break;
                }
                case '-': {
                    subAction('/');
                    break;
                }
                case '*': {
                    mulAction('/');
                    break;
                }
                case '/': {
                    divAction('/');
                    break;
                }
                case '0': {
                    noAction('/');
                    break;
                }
            }
        }

        resultTextView.setText(text);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putChar(KEY_ACTION, action);
        outState.putString(KEY_RESULT, text.toString());
        outState.putInt(KEY_NUM1, num1);
        outState.putInt(KEY_NUM2, num2);
    }
}
