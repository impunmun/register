package com.example.puneet.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_register extends AppCompatActivity {
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn1=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        btn3=(Button)findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),login_page.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),login_with_otp.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),reg_page.class);
                startActivity(i);
            }
        });
    }
}
