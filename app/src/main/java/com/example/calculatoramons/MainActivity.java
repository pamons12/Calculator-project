package com.example.calculatoramons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView screenTextView;
    private String operation="";
    private String currentNum="0";
    List<String> enteredNums = new List<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenTextView = (TextView) findViewById(R.id.screenTextView);

        Button cButton = (Button) findViewById(R.id.cButton);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.length()==1 || Pattern.matches("[-]\\d+",currentNum)){
                    currentNum="0";
                } else{
                    currentNum = currentNum.substring(0,currentNum.length()-1);
                }
                screenTextView.setText(currentNum);
            }
        });
        Button ceButton = (Button) findViewById(R.id.ceButton);
        ceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum="0";
                operation="";
                screenTextView.setText(currentNum);
            }
        });
        Button posNegButton = (Button) findViewById(R.id.posNegButton);
        posNegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("[-]+\\d+",currentNum)){
                    currentNum=currentNum.substring(1,currentNum.length());
                }else{
                    currentNum="-"+currentNum;
                }
                screenTextView.setText(currentNum);
            }
        });

        Button equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),currentNum,Toast.LENGTH_SHORT).show();
            }
        });

        //Arithmatic operations
        Button plusButton = (Button) findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="plus";
                Toast.makeText(getApplicationContext(),"Addition",Toast.LENGTH_SHORT).show();
            }
        });
        Button minusButton = (Button) findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="subtract";
                Toast.makeText(getApplicationContext(),"Subtraction",Toast.LENGTH_SHORT).show();
            }
        });
        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="multiply";
                Toast.makeText(getApplicationContext(),"Multiplication",Toast.LENGTH_SHORT).show();
            }
        });
        Button divideButton = (Button) findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="division";
                Toast.makeText(getApplicationContext(),"Division",Toast.LENGTH_SHORT).show();
            }
        });

        //Number 0-9 Buttons
        Button zeroButton = (Button) findViewById(R.id.zeroButton);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="0";
                }else{
                    currentNum+="0";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button oneButton = (Button) findViewById(R.id.oneButton);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="1";
                }else{
                    currentNum+="1";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button twoButton = (Button) findViewById(R.id.twoButton);
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="2";
                }else{
                    currentNum+="2";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button threeButton = (Button) findViewById(R.id.threeButton);
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="3";
                }else{
                    currentNum+="3";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button fourButton = (Button) findViewById(R.id.fourButton);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="4";
                }else{
                    currentNum+="4";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="5";
                }else{
                    currentNum+="5";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button sixButton = (Button) findViewById(R.id.sixButton);
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="6";
                }else{
                    currentNum+="6";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="7";
                }else{
                    currentNum+="7";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button eightButton = (Button) findViewById(R.id.eightButton);
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="8";
                }else{
                    currentNum+="8";
                }
                screenTextView.setText(currentNum);
            }
        });
        Button nineButton = (Button) findViewById(R.id.nineButton);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.equals("0")){
                    currentNum="9";
                }else{
                    currentNum+="9";
                }
                screenTextView.setText(currentNum);
            }
        });

        public void addValueToListAndReset(){
            enteredNums.add(currentNum);
            currentNum="0";

        }

    }
}