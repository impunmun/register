package com.example.puneet.register;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    Button login;
    EditText et1,et2;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.ed1);
        et2=(EditText)findViewById(R.id.ed2);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                db = new dbhelper(login_page.this);
                Cursor c1 = db.getInsertedData();
                ;
                //int i=0;
                String str1, str2;
                int fl = 0;
                str1 = et1.getText().toString();
                str2 = et2.getText().toString();
                if (str1.isEmpty() || str2.isEmpty()) {
                    Toast.makeText(getBaseContext(),"Empty  "+"Email-id or password not accepted  ",Toast.LENGTH_LONG).show();
                } else {
                    if (c1.moveToFirst()) {
                        do {
                            //stringArrayList.add(json_data.getString("xCoord")); //add to arraylist
                            if (c1.getString(2).equals(str1)&&c1.getString(3).equals(str2)) {
                                fl=1;
                                Toast.makeText(getBaseContext(), "Hello "+c1.getString(1), Toast.LENGTH_LONG).show();
                                break;
                            }
                        } while (c1.moveToNext());

                    }
                    if (fl == 0)
                        Toast.makeText(login_page.this, "Invalid Email-id or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
