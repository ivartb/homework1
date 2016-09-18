package ru.ifmo.android_2016.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            text.delete(0, text.length());
            text.append(savedInstanceState.getString(KEY_RESULT));
            resultTextView.setText(text);
            action = savedInstanceState.getChar(KEY_ACTION);
            num1 = savedInstanceState.getInt(KEY_NUM1);
            num2 = savedInstanceState.getInt(KEY_NUM2);
        }
    }

    @Override
    public void onClick(View v) {
        if (action == '0') {
            if (v == d0Button)
                text.append("0");
            if (v == d1Button)
                text.append("1");
            if (v == d2Button)
                text.append("2");
            if (v == d3Button)
                text.append("3");
            if (v == d4Button)
                text.append("4");
            if (v == d5Button)
                text.append("5");
            if (v == d6Button)
                text.append("6");
            if (v == d7Button)
                text.append("7");
            if (v == d8Button)
                text.append("8");
            if (v == d9Button)
                text.append("9");
        }
        else {
            if (v == d0Button) {
                text.append("0");
                num2 = num2 * 10 + 0;
            }
            if (v == d1Button) {
                text.append("1");
                num2 = num2 * 10 + 1;
            }
            if (v == d2Button) {
                text.append("2");
                num2 = num2 * 10 + 2;
            }
            if (v == d3Button) {
                text.append("3");
                num2 = num2 * 10 + 3;
            }
            if (v == d4Button) {
                text.append("4");
                num2 = num2 * 10 + 4;
            }
            if (v == d5Button) {
                text.append("5");
                num2 = num2 * 10 + 5;
            }
            if (v == d6Button) {
                text.append("6");
                num2 = num2 * 10 + 6;
            }
            if (v == d7Button) {
                text.append("7");
                num2 = num2 * 10 + 7;
            }
            if (v == d8Button) {
                text.append("8");
                num2 = num2 * 10 + 8;
            }
            if (v == d9Button) {
                text.append("9");
                num2 = num2 * 10 + 9;
            }
        }

        if (v == clearButton) {
            text.delete(0, text.length());
            num1 = 0;
            num2 = 0;
            action = '0';
        }

        if (v == eqvButton) {
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
                    num1 = num1 / num2;
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

        if (v == addButton) {
             switch (action) {
                    case '+': {
                        num1 = num1 + num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('+');
                        action = '+';
                        break;
                    }
                    case '-': {
                        num1 = num1 - num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('+');
                        action = '+';
                        break;
                    }
                    case '*': {
                        num1 = num1 * num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('+');
                        action = '+';
                        break;
                    }
                    case '/': {
                        if (num2 != 0) {
                            num1 = num1 / num2;
                            num2 = 0;
                            text.delete(0, text.length());
                            text.append(num1).append('+');
                            action = '+';
                        }
                        else {
                            text.delete(0, text.length());
                            text.append("ERROR");
                            action = '0';
                            num1 = 0;
                            num2 = 0;
                        }
                        break;
                    }
                    case '0': {
                        if (text.toString() == "")
                            num1 = 0;
                        else
                            num1 = Integer.parseInt(text.toString());
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append("+");
                        action = '+';
                        break;
                    }
             }

        }

        if (v == subButton) {
            switch (action) {
                case '+': {
                    num1 = num1 + num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('-');
                    action = '-';
                    break;
                }
                case '-': {
                    num1 = num1 - num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('-');
                    action = '-';
                    break;
                }
                case '*': {
                    num1 = num1 * num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('-');
                    action = '-';
                    break;
                }
                case '/': {
                    if (num2 != 0) {
                        num1 = num1 / num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('-');
                        action = '-';
                    }
                    else {
                        text.delete(0, text.length());
                        text.append("ERROR");
                        action = '0';
                        num1 = 0;
                        num2 = 0;
                    }
                    break;
                }
                case '0': {
                    if (text.toString() == "")
                        num1 = 0;
                    else
                        num1 = Integer.parseInt(text.toString());
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append("-");
                    action = '-';
                    break;
                }
            }

        }

        if (v == mulButton) {
            switch (action) {
                case '+': {
                    num1 = num1 + num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('*');
                    action = '*';
                    break;
                }
                case '-': {
                    num1 = num1 - num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('*');
                    action = '*';
                    break;
                }
                case '*': {
                    num1 = num1 * num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('*');
                    action = '*';
                    break;
                }
                case '/': {
                    if (num2 != 0) {
                        num1 = num1 / num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('*');
                        action = '*';
                    }
                    else {
                        text.delete(0, text.length());
                        text.append("ERROR");
                        action = '0';
                        num1 = 0;
                        num2 = 0;
                    }
                    break;
                }
                case '0': {
                    if (text.toString() == "")
                        num1 = 0;
                    else
                        num1 = Integer.parseInt(text.toString());
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append("*");
                    action = '*';
                    break;
                }
            }

        }

        if (v == divButton) {
            switch (action) {
                case '+': {
                    num1 = num1 + num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('/');
                    action = '/';
                    break;
                }
                case '-': {
                    num1 = num1 - num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('/');
                    action = '/';
                    break;
                }
                case '*': {
                    num1 = num1 * num2;
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append('/');
                    action = '/';
                    break;
                }
                case '/': {
                    if (num2 != 0) {
                        num1 = num1 / num2;
                        num2 = 0;
                        text.delete(0, text.length());
                        text.append(num1).append('/');
                        action = '/';
                    }
                    else {
                        text.delete(0, text.length());
                        text.append("ERROR");
                        action = '0';
                        num1 = 0;
                        num2 = 0;
                    }
                    break;
                }
                case '0': {
                    if (text.toString() == "")
                        num1 = 0;
                    else
                        num1 = Integer.parseInt(text.toString());
                    num2 = 0;
                    text.delete(0, text.length());
                    text.append(num1).append("/");
                    action = '/';
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
