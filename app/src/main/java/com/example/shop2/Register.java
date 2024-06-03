package com.example.shop2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    EditText editEmail2, editPassword2, editAge, editPhone, editHomeAddress;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonOther;

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //Anh xa
        //editEmail1 = findViewById(R.id.editEmail1);
        //editPassword1 = findViewById(R.id.editPassword1);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonOther = findViewById(R.id.radioButtonOther);
        /*
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonMale.isChecked()) {

                }
                if (radioButtonFemale.isChecked()) {

                }
                if (radioButtonOther.isChecked()) {

                }
            }
        });

         */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onRadioButtonClicked(View view) {

    }
}