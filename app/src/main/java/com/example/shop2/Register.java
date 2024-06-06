package com.example.shop2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";

    EditText editEmail2, editPassword2;
    //editAge, editPhone, editHomeAddress;
    //RadioButton radioButtonMale, radioButtonFemale, radioButtonOther;
    Button registerButton;
    //FirebaseDatabase database;
    //DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //Anh xa
        //database = FirebaseDatabase.getInstance();
        //reference = database.getReference();
        editEmail2 = findViewById(R.id.editEmail2);
        editPassword2 = findViewById(R.id.editPassword2);
        //editAge = findViewById(R.id.editAge);
        //editPhone = findViewById(R.id.editPhone);
        //editHomeAddress = findViewById(R.id.editHomeAddress);
        //radioButtonMale = findViewById(R.id.radioButtonMale);
        //radioButtonFemale = findViewById(R.id.radioButtonFemale);
        //radioButtonOther = findViewById(R.id.radioButtonOther);
        registerButton = findViewById(R.id.registerButton); // Initialize registerButton

        // Register Button Click Listener
        /*
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> information = new HashMap<>();
                String email = editEmail2.getText().toString();
                String password = editPassword2.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());
                String gender = "";
                if (radioButtonMale.isChecked()) {
                    gender = "Male";
                }
                if (radioButtonFemale.isChecked()) {
                    gender = "Female";
                }
                if (radioButtonOther.isChecked()) {
                    gender = "Other";
                }
                int phone = Integer.parseInt(editPhone.getText().toString());
                String homeAddress = editHomeAddress.getText().toString();
                //After create account successfully
                information.put("Email", email);
                information.put("Password", password);
                information.put("Age", age);
                information.put("Gender", gender);
                information.put("Phone", phone);
                information.put("Address", homeAddress);
                reference.child("User")
                        .setValue(information)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override

                    public void onSuccess(Void unused) {
                        Toast.makeText(Register.this,
                                "Create account successfully",
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

         */
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(editEmail2.getText().toString(), editPassword2.getText().toString());
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }
    /*
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

     */
    private void reload() { }
    private void updateUI(FirebaseUser user) {

    }
}