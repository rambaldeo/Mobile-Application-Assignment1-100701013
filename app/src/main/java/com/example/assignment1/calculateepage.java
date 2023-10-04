package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;


public class calculateepage extends AppCompatActivity {
    private EditText principalAmountEditText, interestRateEditText;
    private Spinner loanTermSpinner;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculateepage);

        principalAmountEditText = findViewById(R.id.principalAmount);
        interestRateEditText = findViewById(R.id.interestRate);
        loanTermSpinner = findViewById(R.id.loanTermSpinner);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.loan_terms,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loanTermSpinner.setAdapter(adapter);
        loanTermSpinner.setPrompt("Select Loan Term");

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateMonthlyPayment();
            }
        });


        Button b1 = findViewById(R.id.toHome);;
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ToNewNote = new Intent(calculateepage.this,MainActivity.class);
                        startActivity(ToNewNote);
                    }
                }
        );//SetOnClickListener function

    }
    private void calculateMonthlyPayment() {
        double principalAmount = Double.parseDouble(principalAmountEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());

        // Get selected loan term from the spinner
        String selectedTerm = loanTermSpinner.getSelectedItem().toString();
        int loanTerm = Integer.parseInt(selectedTerm.split(" ")[0]);
        //calculation logic
        //Find the number of monthly payments
        int paymentToBeMade = loanTerm * 12;
        //convert the interest rate into a monthly percentage
        double monthlyInterestRate = (interestRate/12)/100;
        //Calculating the Monthly payments
        double result = (principalAmount*(monthlyInterestRate*(Math.pow(1+monthlyInterestRate, paymentToBeMade))) )/((Math.pow(1+monthlyInterestRate, paymentToBeMade))-1) ;

        DecimalFormat df = new DecimalFormat("#.##");
        resultTextView.setText("Monthly Payment: $" + df.format(result));
    }
}