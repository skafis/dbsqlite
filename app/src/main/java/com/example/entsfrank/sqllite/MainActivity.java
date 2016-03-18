package com.example.entsfrank.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    //activate and register the buttons and text fields
    SQLiteDatabase contactsDB = null;
    Button createDBButton, addContactButton, deleteContactButton, getContactsButton, deleteDBButtons;

    EditText nameEditText, emailEditText, contactListEditText, idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDBButton = (Button)findViewById(R.id.createDBButton);
        addContactButton = (Button)findViewById(R.id.addContactButton);
        deleteContactButton = (Button)findViewById(R.id.deleteContactButton);
        getContactsButton = (Button)findViewById(R.id.getContactsButton);
        deleteDBButtons = (Button)findViewById(R.id.deleteDBButton);
        nameEditText= (EditText) findViewById(R.id.nameEditText);
        emailEditText= (EditText) findViewById(R.id.emailEditText);
        contactListEditText= (EditText) findViewById(R.id.contactListEditText);
        idEditText= (EditText) findViewById(R.id.idEditText);

    }

    public void createDatabase(View view) {
        //check database and connection if exist
        try {
            contactsDB=this.openOrCreateDatabase("myDb",
                    MODE_PRIVATE,null);
            contactsDB.execSQL("Crete tableif not there " +
                    "(id integer primary key, name VARCHAR, email VARCHAR);" );

            File database = getApplicationContext().getDatabasePath("myDB.db");

            if (!database.exists()){
                Toast.makeText(this, "Data base created", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "No Database", Toast.LENGTH_SHORT).show();

            }
        }
        catch (Exception e ){
            Log.e("mydb error", "error creating Database");
        }
        //set buttons to be clickable
        addContactButton.setClickable(true);
        deleteContactButton.setClickable(true);
        getContactsButton.setClickable(true);
        deleteDBButtons.setClickable(true);
    }
    //add new row of data to database
    public void addContact(View view) {
        String contactName = nameEditText.getText().toString();
        String contactEmail = emailEditText.getText().toString();
        //insert into DB
        contactsDB.execSQL("INSERT INTO contacts(name, email)VALUES('" + contactName + ",'" + contactEmail + "');");

    }
    public void getContacts(View view) {
    }
    public void deleteContact(View view) {
    }
}
