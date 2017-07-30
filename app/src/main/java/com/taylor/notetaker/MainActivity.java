package com.taylor.notetaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
    private Button mEncryptButton;
    private Button mVaultButton;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        mEncryptButton = (Button) findViewById(R.id.button_encryptactivity);
        mVaultButton = (Button) findViewById(R.id.button_vaultactivity);

        mEncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartEncrypt();
            }
        });

        mVaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartVault();
            }
        });
        */
    }

    public void StartEncrypt(View v){
        Intent intent = new Intent(this, EncryptActivity.class);
        startActivity(intent);
    }

    public void StartVault(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
