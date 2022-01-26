package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    // declare text view for the result text
    TextView result_text;

    // declare buttons for all numbers, operators, clear button and version button
    Button num_1_btn;
    Button num_2_btn;
    Button num_3_btn;
    Button num_4_btn;
    Button num_5_btn;
    Button num_6_btn;
    Button num_7_btn;
    Button num_8_btn;
    Button num_9_btn;
    Button num_0_btn;

    Button add_btn;
    Button subtract_btn;
    Button divide_btn;
    Button multiply_btn;
    Button equals_btn;
    Button modulo_btn;
    Button power_btn;
    Button minimum_btn;
    Button maximum_btn;

    Button clear_btn;
    Button version_btn;

    // declare a calculator
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator(); // create a new calculator

        result_text = findViewById(R.id.input_text); // point result text view to input text view on layout

        // point number buttons to number buttons on layout and set on click listener for each
        num_1_btn = findViewById(R.id.number_1);
        num_1_btn.setOnClickListener(this);
        num_2_btn = findViewById(R.id.number_2);
        num_2_btn.setOnClickListener(this);
        num_3_btn = findViewById(R.id.number_3);
        num_3_btn.setOnClickListener(this);
        num_4_btn = findViewById(R.id.number_4);
        num_4_btn.setOnClickListener(this);
        num_5_btn = findViewById(R.id.number_5);
        num_5_btn.setOnClickListener(this);
        num_6_btn = findViewById(R.id.number_6);
        num_6_btn.setOnClickListener(this);
        num_7_btn = findViewById(R.id.number_7);
        num_7_btn.setOnClickListener(this);
        num_8_btn = findViewById(R.id.number_8);
        num_8_btn.setOnClickListener(this);
        num_9_btn = findViewById(R.id.number_9);
        num_9_btn.setOnClickListener(this);
        num_0_btn = findViewById(R.id.number_0);
        num_0_btn.setOnClickListener(this);

        // point operator buttons to operator buttons on layout and set on click listener for each
        add_btn = findViewById(R.id.operator_add);
        add_btn.setOnClickListener(this);
        subtract_btn = findViewById(R.id.operator_subtract);
        subtract_btn.setOnClickListener(this);
        divide_btn = findViewById(R.id.operator_divide);
        divide_btn.setOnClickListener(this);
        multiply_btn = findViewById(R.id.operator_multiply);
        multiply_btn.setOnClickListener(this);
        equals_btn = findViewById(R.id.operator_equals);
        equals_btn.setOnClickListener(this);
        modulo_btn = findViewById(R.id.operator_modulo);
        modulo_btn.setOnClickListener(this);
        power_btn = findViewById(R.id.operator_POW);
        power_btn.setOnClickListener(this);
        minimum_btn = findViewById(R.id.operator_MIN);
        minimum_btn.setOnClickListener(this);
        maximum_btn = findViewById(R.id.operator_MAX);
        maximum_btn.setOnClickListener(this);

        // point clear and version buttons to their buttons on layout and set on click listener for each
        clear_btn = findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(this);
        version_btn = findViewById(R.id.version_btn);
        version_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // get id of view
        int id = view.getId();

        // get text of clicked button
        Button b = (Button)view;
        String buttonText = b.getText().toString();

        Toast.makeText(getApplicationContext(), buttonText,Toast.LENGTH_LONG).show(); // DELETE LATER - DEBUGGING

        // if the clear button is clicked, clear calculator and set text to ""
        if (id == R.id.clear_btn){
            calculator.clear();
            result_text.setText(calculator.getValues());
        }

        // if the equals sign (=) is clicked
        else if (id == R.id.operator_equals) {
            // get result from calculate function
            int res = calculator.calculate();

            if (res == -999){
                result_text.setText(calculator.getValues() + " = Not an Operation");
            }
            else {
                result_text.setText(calculator.getValues() + " = " + res);
            }

            calculator.clear();
            /**

            // check if user values were cleared (these get cleared after calculating)
            // if not cleared, that means there is an error

            // if user values are empty, calculation was successful, set text to result
            if (calculator.isEmpty()){
                result_text.setText(String.valueOf(res));
            }
            // else calculation was unsuccessful, set text to error
            else {
                result_text.setText(calculator.getValues());
                calculator.clear();
            }
             */
        }

        // if version button is clicked
        else if (id == R.id.version_btn){

            LinearLayout advance_layout = findViewById(R.id.advanced_buttons);

            if (buttonText.equalsIgnoreCase("STANDARD")){
                b.setText("ADVANCE - SCIENTIFIC");
                advance_layout.setVisibility(View.GONE);
            }
            else {
                b.setText("STANDARD");
                advance_layout.setVisibility(View.VISIBLE);
            }

        }

        // else, a number or operator was clicked
        // push the button text into the calculator and update the display text
        else {
            calculator.push(buttonText);
            result_text.setText(calculator.getValues());
        }
    }
}