package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    EditText area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        area = findViewById(R.id.area);
        TextView c = findViewById(R.id.c);
        TextView per = findViewById(R.id.per);
        TextView prevText = findViewById(R.id.textView);
        ImageView delete = findViewById(R.id.delete);
        TextView divide = findViewById(R.id.divide);
        TextView seven = findViewById(R.id.seven);
        TextView eight = findViewById(R.id.eight);
        TextView nine = findViewById(R.id.nine);
        TextView multiply = findViewById(R.id.multiply);
        TextView four = findViewById(R.id.four);
        TextView five = findViewById(R.id.five);
        TextView six = findViewById(R.id.six);
        TextView minus = findViewById(R.id.minus);
        TextView one = findViewById(R.id.one);
        TextView two = findViewById(R.id.two);
        TextView three = findViewById(R.id.three);
        TextView add = findViewById(R.id.add);
        TextView zeroes = findViewById(R.id.zeroes);
        TextView zero = findViewById(R.id.zero);
        TextView point = findViewById(R.id.point);
        TextView equals = findViewById(R.id.equals);
        area.setShowSoftInputOnFocus(false);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!area.getText().toString().equals(""))
                    area.setText("");
                prevText.setText("");
            }
        });

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                if (!area.getText().toString().equals("") && !exp.endsWith("+") && !exp.endsWith("-") && !exp.endsWith("%") && !exp.endsWith("÷") && !exp.endsWith("×")) {
                    updateEditView(getResources().getString(R.string.percent),exp);
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.one),area.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.two),area.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.three),area.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.four),area.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.five),area.getText().toString());
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.six),area.getText().toString());
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.seven),area.getText().toString());
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.eight),area.getText().toString());
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEditView(getResources().getString(R.string.nine),area.getText().toString());
            }
        });

        zeroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area.getText().toString().equals("")) {
                    area.setText("0");
                    area.setSelection(1);
                }
                else if (!area.getText().toString().equals("0"))
                    updateEditView(getResources().getString(R.string.zeroes),area.getText().toString());
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area.getText().toString().equals("")) {
                    area.setText("0");
                    area.setSelection(1);
                }
                else if (!area.getText().toString().equals("0"))
                    updateEditView(getResources().getString(R.string.zero),area.getText().toString());
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (area.getText().toString().equals(""))
                    area.setText("0.");
                else
                    updateEditView(getResources().getString(R.string.point),area.getText().toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                int curPos = area.getSelectionStart();
                if (!exp.equals("") && curPos!=0) {
                    String leftStr = exp.substring(0,curPos-1);
                    String rightStr = exp.substring(curPos);
                    area.setText(String.format("%s%s",leftStr,rightStr));
                    area.setSelection(curPos-1);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                if (!area.getText().toString().equals("") && !exp.endsWith("+") && !exp.endsWith("-") && !exp.endsWith("%") && !exp.endsWith("÷") && !exp.endsWith("×"))
                    updateEditView(getResources().getString(R.string.divide),area.getText().toString());
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                if (!area.getText().toString().equals("") && !exp.endsWith("+") && !exp.endsWith("-") && !exp.endsWith("÷") && !exp.endsWith("×"))
                    updateEditView(getResources().getString(R.string.multiply),area.getText().toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                if (!area.getText().toString().equals("") && !exp.endsWith("+") && !exp.endsWith("-") && !exp.endsWith("%") && !exp.endsWith("÷") && !exp.endsWith("×"))
                    updateEditView(getResources().getString(R.string.subtract),area.getText().toString());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String exp = area.getText().toString();
                if (!area.getText().toString().equals("") && !exp.endsWith("+") && !exp.endsWith("-") && !exp.endsWith("%") && !exp.endsWith("÷") && !exp.endsWith("×"))
                    updateEditView(getResources().getString(R.string.add),area.getText().toString());
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = area.getText().toString();
                if (!exp.equals("")  && !exp.endsWith("×") && !exp.endsWith("÷") && !exp.endsWith("-") && !exp.endsWith("+")) {
                    prevText.setText(exp);
                    exp = exp.replaceAll("÷", "/");
                    exp = exp.replaceAll("×", "*");
                    Expression expression = new Expression(exp);
                    if (expression.calculate() == (int) expression.calculate()) {
                        String ans = String.valueOf((int) expression.calculate());
                        area.setText(ans);
                        area.setSelection(ans.length());
                    }
                    else {
                        String ans = String.valueOf(expression.calculate());
                        area.setText(ans);
                        area.setSelection(ans.length());
                    }
                }
            }
        });
    }

    public void updateEditView(String val,String exp){
        int curPos = area.getSelectionStart();
        String leftStr = exp.substring(0,curPos);
        String rightStr = exp.substring(curPos);
        area.setText(String.format("%s%s%s",leftStr,val,rightStr));
        area.setSelection(curPos+val.length());
    }

    public void parOpenBTNPush(View view){
        updateEditView("(",area.getText().toString());
    }

    public void parCloseBTNPush(View view){
        updateEditView(")",area.getText().toString());
    }

    public void trigSinBTNPush(View view){
        updateEditView("sin(rad(",area.getText().toString());
    }

    public void trigCosBTNPush(View view){
        updateEditView("cos(rad(",area.getText().toString());
    }

    public void trigTanBTNPush(View view){
        updateEditView("tan(rad(",area.getText().toString());
    }

    public void trigArcSinBTNPush(View view){
        updateEditView("deg(arcsin(",area.getText().toString());
    }

    public void trigArcCosBTNPush(View view){
        updateEditView("deg(arccos(",area.getText().toString());
    }

    public void trigArcTanBTNPush(View view){
        updateEditView("deg(arctan(",area.getText().toString());
    }

    public void naturalLogBTNPush(View view){
        updateEditView("ln(",area.getText().toString());
    }

    public void logBTNPush(View view){
        updateEditView("log10(",area.getText().toString());
    }

    public void sqrtBTNPush(View view){
        updateEditView("sqrt(",area.getText().toString());
    }

    public void absBTNPush(View view){
        updateEditView("abs(",area.getText().toString());
    }

    public void piBTNPush(View view){
        updateEditView("pi",area.getText().toString());
    }

    public void eBTNPush(View view){
        updateEditView("e",area.getText().toString());
    }

    public void xSquaredBTNPush(View view){
        String text = area.getText().toString();
        if (!text.equals(""))
            updateEditView("^(2)",text);
    }

    public void xPowerYBTNPush(View view){
        String text = area.getText().toString();
        if (!text.equals(""))
            updateEditView("^(",text);
    }
}