package com.example.stakemines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputFormActivity extends AppCompatActivity {

    EditText firstName ;
    EditText lastName;
    EditText email;
    EditText password;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstName = findViewById(R.id.edtInputFormFirstName);
        lastName = findViewById(R.id.edtInputFormLastName);
        email = findViewById(R.id.edtInputFormEmail);
        password = findViewById(R.id.edtInputFormPassword);
        submit = findViewById(R.id.btnInputFormSubmit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = firstName.getText().toString();
                String lname = lastName.getText().toString();
                String mailId = email.getText().toString();
                String pass = password.getText().toString();

                Intent intent = new Intent(InputFormActivity.this,GameActivity.class);
                intent.putExtra("fname",fname);
                intent.putExtra("lname",lname);
                intent.putExtra("mailId",mailId);
                intent.putExtra("pass",pass);
                startActivity(intent);

            }
        });




    }
}