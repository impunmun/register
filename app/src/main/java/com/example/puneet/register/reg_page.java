package com.example.puneet.register;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class reg_page extends AppCompatActivity {
    Button insert;
    //TextView tv1,tv2;
    EditText et1,et2,et3;
    dbhelper db;
    //String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        insert=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.ed1);
        et2=(EditText)findViewById(R.id.ed2);
        et3=(EditText)findViewById(R.id.ed3);


        db=new dbhelper(this);
        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                String s3=et3.getText().toString();
                if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty())
                {
                    if(s1.isEmpty())
                        Toast.makeText(getBaseContext(),"Empty  "+"name  ",Toast.LENGTH_LONG).show();
                    else if(s2.isEmpty())
                        Toast.makeText(getBaseContext(),"Empty  "+"Email-id ",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getBaseContext(),"Empty  "+"password ",Toast.LENGTH_LONG).show();
                }
                else {
                    db.insert(et1.getText().toString(), et2.getText().toString(), et3.getText().toString());

                    Toast.makeText(getBaseContext(), "Successfully registered ", Toast.LENGTH_LONG).show();
                    //showDataOnToast();
                }

            }
        });    }
    protected void showDataOnToast() {
        // TODO Auto-generated method stub
        Cursor c=db.getInsertedData();
        if(c.moveToFirst())
        {
            do
            {
                Toast.makeText(this, "id: "+c.getString(0)+"\n"+
                        "Name: "+c.getString(1)+"\n"+
                        "EmailId: "+c.getString(2), Toast.LENGTH_LONG).show();
            }while(c.moveToNext());
        }
        db.close();
    }

}



