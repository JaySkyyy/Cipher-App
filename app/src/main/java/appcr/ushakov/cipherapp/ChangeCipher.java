package appcr.ushakov.cipherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeCipher extends AppCompatActivity {

    private Button btn_ENTER;
    private EditText edit_name;
    private TextView text_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_cipher);

        Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ChangeCipher.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        btn_ENTER = findViewById(R.id.btn_ENTER);
        edit_name = findViewById(R.id.edit_name);
        text_name = findViewById(R.id.text_name);

        btn_ENTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();

                String encryptedString = encrypt(name);
                text_name.setText(encryptedString);
            }
        });

    }

    public static String encrypt(String plaintext) {
        String ciphertext = "";
        plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                int num = (int) ch - 'А' + 1;
                ciphertext += num + "-";
            } else {
                ciphertext += ch;
            }
        }
        ciphertext = ciphertext.substring(0, ciphertext.length() - 1);
        return ciphertext;
    }

}