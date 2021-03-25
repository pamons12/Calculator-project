package com.example.calculatoramons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView screenTextView;
    private String operation="";
    private String currentNum="0";
    private String totalNumWithOp="";
    private String result="";

    List<String> listOfNumAndOp = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenTextView = (TextView) findViewById(R.id.screenTextView);

        Button cButton = (Button) findViewById(R.id.cButton);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum.length()==1 || Pattern.matches("[n]+\\d?",currentNum)){
                    currentNum="0";
                } else{
                    currentNum = currentNum.substring(0,currentNum.length()-1);
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button ceButton = (Button) findViewById(R.id.ceButton);
        ceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum="0";
                operation="";
                totalNumWithOp="";
                listOfNumAndOp.clear();
                screenTextView.setText(currentNum);
            }
        });
        Button posNegButton = (Button) findViewById(R.id.posNegButton);
        posNegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (Pattern.matches("[n]+\\d+",currentNum)){
                    currentNum=currentNum.substring(1,currentNum.length());
                    screenTextView.setText(currentNum);
                }else{
                    screenTextView.setText("-"+currentNum);
                    currentNum="n"+currentNum;
                }
            }
        });

        Button equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNumWithOp+=currentNum;

                //For testing
                //totalNumWithOp="8/4";

                if(checkSyntax(totalNumWithOp)) {
                    result = doCalculation();
                }else{
                    result = totalNumWithOp;
                }
                currentNum="0";
                operation="";
                totalNumWithOp="";
                listOfNumAndOp.clear();
                screenTextView.setText(result);
            }
        });

        //Arithmatic operations
        Button plusButton = (Button) findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="+";
                Toast.makeText(getApplicationContext(),"Addition",Toast.LENGTH_SHORT).show();
            }
        });
        Button minusButton = (Button) findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="-";
                Toast.makeText(getApplicationContext(),"Subtraction",Toast.LENGTH_SHORT).show();
            }
        });
        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="*";
                Toast.makeText(getApplicationContext(),"Multiplication",Toast.LENGTH_SHORT).show();
            }
        });
        Button divideButton = (Button) findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation="/";
                Toast.makeText(getApplicationContext(),"Division",Toast.LENGTH_SHORT).show();
            }
        });

        //Number 0-9 Buttons
        Button zeroButton = (Button) findViewById(R.id.zeroButton);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    currentNum="0";
                }else{
                    currentNum+="0";
                }
                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button oneButton = (Button) findViewById(R.id.oneButton);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="1";
                    }else{
                        currentNum="n1";
                    }
                }else{
                    currentNum+="1";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button twoButton = (Button) findViewById(R.id.twoButton);
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="2";
                    }else{
                        currentNum="n2";
                    }
                }else{
                    currentNum+="2";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button threeButton = (Button) findViewById(R.id.threeButton);
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="3";
                    }else{
                        currentNum="n3";
                    }
                }else{
                    currentNum+="3";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button fourButton = (Button) findViewById(R.id.fourButton);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="4";
                    }else{
                        currentNum="n4";
                    }
                }else{
                    currentNum+="4";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="5";
                    }else{
                        currentNum="n5";
                    }
                }else{
                    currentNum+="5";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button sixButton = (Button) findViewById(R.id.sixButton);
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="6";
                    }else{
                        currentNum="n6";
                    }
                }else{
                    currentNum+="6";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="7";
                    }else{
                        currentNum="n7";
                    }
                }else{
                    currentNum+="7";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button eightButton = (Button) findViewById(R.id.eightButton);
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="8";
                    }else{
                        currentNum="n8";
                    }
                }else{
                    currentNum+="8";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });
        Button nineButton = (Button) findViewById(R.id.nineButton);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operation.equals("")){
                    totalNumWithOp+=currentNum+operation;
                    currentNum="0";
                    operation="";
                }
                if (currentNum.equals("0") || currentNum.equals("n0")){
                    if (currentNum.equals("0")){
                        currentNum="9";
                    }else{
                        currentNum="n9";
                    }
                }else{
                    currentNum+="9";
                }

                if (Pattern.matches("[n]+\\d+",currentNum)){
                    String firstRemoved = currentNum.substring(1);
                    screenTextView.setText("-"+currentNum.substring(1));
                }else {
                    screenTextView.setText(currentNum);
                }
            }
        });


    }

    private boolean checkSyntax(String totalNumWithOp) {

        //Expression that is neg or pos followed by digit and operation
        Matcher matcher = Pattern.compile("[n]?\\d+\\D{1}").matcher(totalNumWithOp);
        while (matcher.find()) {
            listOfNumAndOp.add(matcher.group());
        }

        //Digit followed by no operation, can be pos or neg
        matcher = Pattern.compile("[n]?\\d+$").matcher(totalNumWithOp);
        while (matcher.find()) {
            listOfNumAndOp.add(matcher.group());
        }

        if (listOfNumAndOp.size()==1){
            return false;
        }else{
            return true;
        }
    }

    private String doCalculation() {
        Integer runningTotal=0;
        runningTotal = doOperation("*",runningTotal);
        runningTotal = doOperation("/",runningTotal);
        runningTotal = doOperation("+",runningTotal);
        runningTotal = doOperation("-",runningTotal);
        return runningTotal.toString();
    }

    private int doOperation(String operation,Integer runningTotal) {
        String currentString;
        String lastChar;
        String nextString;
        Integer currentValue;
        Integer nextValueInt;
        Integer currentValueSign;
        Integer nextValueSign;

        //Checks entire list/all values in the list
        for (int i = 0; i < listOfNumAndOp.size(); i++) {
            //The string we are currently looking at
            currentString = listOfNumAndOp.get(i);
            //Last char of the string we are looking at
            lastChar = String.valueOf(listOfNumAndOp.get(i).charAt(currentString.length() - 1));

            //If currentString is only d, skips iteration, nothing to be done
            if (Pattern.matches("[d]{1}",currentString)) {
                continue;
            }

            //Attempts to see if value is neg
            if (Pattern.matches("[n]{1}\\d+\\D?",currentString)){
                currentString = currentString.substring(1);
                currentValueSign=-1;
            }else {
                currentValueSign=1;
            }

            //Attemps to convert current string to current value (an int)
            //If currentString is d(operation)
            if (Pattern.matches("[d]+\\D{1}", currentString)) {
                currentValue = runningTotal;
            } else {

                //currentString has a operation at the end
                if (currentString.length() > 1) {
                    currentValue = Integer.parseInt(currentString.substring(0, currentString.length() - 1));
                    currentValue *= currentValueSign;

                    //currentString is just a number, no operation
                } else {
                    currentValue = Integer.parseInt(currentString);
                    currentValue *= currentValueSign;
                }
            }
            if (lastChar.equals(operation)) {
                nextString = listOfNumAndOp.get(i + 1);

                //Check for d, if value has been operated on before
                if (Pattern.matches("[d]{1}", nextString)) {

                    //Checks operation to do the correct operation
                    if (operation.equals("*")){
                        runningTotal = currentValue * runningTotal;
                    }else if (operation.equals("/")){
                        runningTotal = currentValue / runningTotal;
                    } else if (operation.equals("+")){
                        runningTotal = currentValue + runningTotal;
                    }else {
                        runningTotal = currentValue - runningTotal;
                    }
                    //Set current string to d, removing the operation from the end
                    // Because it was just operated on
                    listOfNumAndOp.set(i,"d");

                } else {

                    //Attempts to see if next string is neg
                    if (Pattern.matches("[n]{1}\\d+\\D?",nextString)){
                        nextString = nextString.substring(1);
                        nextValueSign=-1;
                    }else {
                        nextValueSign=1;
                    }

                    //If nextValue is just a digit, the last number in the overall string ie: 3 in 1+2+3
                    if (Pattern.matches("\\d+$", nextString)) {
                        //Convert nextString to int
                        nextValueInt = Integer.parseInt(nextString);
                        nextValueInt *= nextValueSign;

                        //Checks operation to do the correct operation
                        if (operation.equals("*")){
                            runningTotal = currentValue * nextValueInt;
                        }else if (operation.equals("/")){
                            runningTotal = currentValue / nextValueInt;
                        } else if (operation.equals("+")){
                            runningTotal = currentValue + nextValueInt;
                        }else {
                            runningTotal = currentValue - nextValueInt;
                        }

                        //Set both next string and current string to d
                        //Because they have been operated on and next value is just a digit
                        // so it does not need its operation saved appended
                        listOfNumAndOp.set(i + 1,"d");
                        listOfNumAndOp.set(i,"d");

                        //If next value is a normal string so not last in overall string ie: 123+
                    } else {
                        //Convert nextString to int, excluding the operation
                        nextValueInt = Integer.parseInt(nextString.substring(0, nextString.length() - 1));
                        nextValueInt *= nextValueSign;

                        //Checks operation to do the correct operation
                        if (operation.equals("*")){
                            runningTotal = currentValue * nextValueInt;
                        }else if (operation.equals("/")){
                            runningTotal = currentValue / nextValueInt;
                        } else if (operation.equals("+")){
                            runningTotal = currentValue + nextValueInt;
                        }else {
                            runningTotal = currentValue - nextValueInt;
                        }

                        //Set to next string to d(operation) and current string to d
                        //Because they have been operated on
                        listOfNumAndOp.set(i + 1, "d" + String.valueOf(nextString.charAt(nextString.length() - 1)));
                        listOfNumAndOp.set(i,"d");
                    }
                }
            }
        }
        return runningTotal;
    }
    private void printList(){
        for(int i=0;i<listOfNumAndOp.size();i++){
            System.out.print(listOfNumAndOp.get(i)+" ");
        }
    }

}