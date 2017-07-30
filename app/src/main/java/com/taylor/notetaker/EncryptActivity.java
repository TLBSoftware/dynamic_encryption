package com.taylor.notetaker;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tnayr on 8/2/2016.
 */
public class EncryptActivity extends AppCompatActivity {

    private EditText mMessage;
    private EditText mKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        mMessage = (EditText) findViewById(R.id.editText_Message);
        mKey = (EditText) findViewById(R.id.editText_Key);


    }

    public void EncryptMessage(View v){
        /*
        if(mMessage.getText().toString() != ""
                &&
                mKey.getText().toString() != ""){
            String message = mMessage.getText().toString();
            String key = mKey.getText().toString();

            Encryptor e = new Encryptor(message, key);
            mMessage.setText(e.EncryptMessageWithKey());
        }else{
            DialogFragment dialog = new EncryptActivityDialog();
            dialog.show(getFragmentManager(), "error");
        }
        */
        String message = mMessage.getText().toString();
        String key = mKey.getText().toString();

        Encryptor e = new Encryptor(message, key);
        mMessage.setText(e.EncryptMessageWithKey());
    }

    public void DecryptMessage(View v){
        /*
        if(mMessage.getText().toString() != ""
                && mKey.getText().toString() != ""){
            String message = mMessage.getText().toString();
            String key = mKey.getText().toString();

            Encryptor e = new Encryptor(message, key);
            mMessage.setText(e.DecryptMessageWithKey());
        }else if (mMessage.getText().toString() == "" && mKey.getText().toString() == ""){

        }else if (mMessage.getText().toString() == ""){
            // Display dialog that wil inform the user that their message is null
        }else if (mKey.getText().toString() == ""){

        }
        */
        String message = mMessage.getText().toString();
        String key = mKey.getText().toString();

        Encryptor e = new Encryptor(message, key);
        mMessage.setText(e.DecryptMessageWithKey());
    }

    public void SaveToVault(View v){
        // Save the encrypted message to the database and then open the message in the note view
    }
}
