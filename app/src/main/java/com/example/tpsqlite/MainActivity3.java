package com.example.tpsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText txtFN;
    EditText txtLN;
    EditText txtMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtFN=(EditText) findViewById(R.id.firstName);
        txtLN=(EditText) findViewById(R.id.lastName);
        txtMail=(EditText) findViewById(R.id.mail);
    }

    public void buSave(View view) {
        DbConnections db=new DbConnections(this);
        String firstName,lastName,mail;
        firstName=txtFN.getText().toString();
        lastName=txtLN.getText().toString();
        mail=txtMail.getText().toString();
        db.insertClientRow(firstName,lastName,mail);
        finish();
    }
}