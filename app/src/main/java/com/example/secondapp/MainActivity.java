package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.pass);
        Button btn = findViewById(R.id.btn);
        ConstraintLayout container2 = findViewById(R.id.container2);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().isEmpty()){
                    btn.setBackgroundColor(btn.getContext().getResources().getColor(R.color.gray));
                }else {
                    password.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if(password.getText().toString().isEmpty()){
                                btn.setBackgroundColor(btn.getContext().getResources().getColor(R.color.gray));
                            }else {
                                btn.setBackgroundColor(btn.getContext().getResources().getColor(R.color.orange));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    container2.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегестрировались", Toast.LENGTH_SHORT).show();
                }else if(email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Вы не ввели данные", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Вы неправильно ввели почту или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}