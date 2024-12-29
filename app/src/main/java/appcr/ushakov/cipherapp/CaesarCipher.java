package appcr.ushakov.cipherapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaesarCipher extends AppCompatActivity {

    private EditText mEditTextMessage;
    private EditText mEditTextKey;
    private TextView mTextViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caesar_cipher);


        mEditTextMessage = findViewById(R.id.edit_text_message);
        mEditTextKey = findViewById(R.id.edit_text_key);
        mTextViewResult = findViewById(R.id.text_view_result);

        // Set up the encrypt button click listener
        Button encryptButton = findViewById(R.id.button_encrypt);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();

                try {
                    int key = Integer.parseInt(mEditTextKey.getText().toString());
                    String encryptedMessage = encrypt(message, key);
                    mTextViewResult.setText(encryptedMessage);
                }catch (Exception e){

                }
            }
        });

        // Set up the decrypt button click listener
        Button decryptButton = findViewById(R.id.button_decrypt);
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();
                int key = Integer.parseInt(mEditTextKey.getText().toString());
                String decryptedMessage = decrypt(message, key);
                mTextViewResult.setText(decryptedMessage);
            }
        });

    }

    // Encrypts a message using the Caesar cipher with the given key
    private String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        int length = message.length();
        for (int i = 0; i < length; i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A'; // set the base character depending on the case
                c = (char) (((c - base + key) % 26 + 26) % 26 + base); // calculate the new character using modulo arithmetic
            }
            result.append(c);
        }
        return result.toString();
    }


    // Decrypts a message using the Caesar cipher with the given key
    private String decrypt(String message, int key) {
        return encrypt(message, -key);
    }



}