package com.example.hw_7;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;






    private Double first;
    private Double second;
    private  Double sum;
    private String operation ;

    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
        button= findViewById(R.id.btn_result);



        findViewById(R.id.btn_result).setOnClickListener(view -> {
            String sum=textView.getText().toString();
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("sum",sum);
            startActivity(intent);
            finish();
        });
        button.setVisibility(GONE);



    }




    public void OnNumberClick(View view) {
        String textButton=((Button)view).getText().toString();
        button.setVisibility(GONE);
        if(textButton.equals("AC")){
            textView.setText("0");
            first=0.0;

        }else if(textView.getText().toString().equals("0")|| isOperationClick) {
            textView.setText(textButton);
        }else if(textButton.equals("+/-")) {
            first= Double.valueOf(textView.getText().toString());
            textView.setText("-"+ first);

        }else{
            textView.append(textButton);
        }
        isOperationClick=false;



    }

    public void OnOperationClick(View view) {
        String textButton=((Button)view).getText().toString();
        switch (textButton){
            case"+":
                first= Double.valueOf(textView.getText().toString());
                operation="+";
                break;
            case"-":
                first= Double.valueOf(textView.getText().toString());
                operation="-";
                break;
            case"*":
                first= Double.valueOf(textView.getText().toString());
                operation="*";
                break;
            case"/":
                first= Double.valueOf(textView.getText().toString());
                operation="/";
                break;

            case "%":
                first= Double.valueOf(textView.getText().toString());
                operation="%";
                break;
            case "=":
                second= Double.valueOf(textView.getText().toString());
                if(button.getVisibility()==View.GONE){
                    button.setVisibility(View.VISIBLE);
                }else{
                    button.setVisibility(View.GONE);
                }


                switch (operation){
                    case "+":
                       sum=first+second;
                        break;
                    case "-":
                        sum= first-second;
                        break;
                    case "*":
                        sum =  first*second;
                        break;
                    case "/":
                        if(second!=0) {
                            sum = first / second;
                        }else{
                            Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "%":
                        sum= (first*second)/100;
                        textView.setText(String.valueOf(sum));
                        break;


                }
                textView.setText(sum.toString());



                break;


        }
        isOperationClick=true;
    }

}