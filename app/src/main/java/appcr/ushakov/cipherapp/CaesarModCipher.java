package appcr.ushakov.cipherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaesarModCipher extends AppCompatActivity {

    private Button btn_ENTER;
    private EditText edit_name;
    private TextView text_name;
    private EditText key_word;
    private EditText key_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caesar_mod_cipher);

        Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(CaesarModCipher.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        btn_ENTER = findViewById(R.id.btn_ENTER);
        edit_name = findViewById(R.id.edit_name);
        text_name = findViewById(R.id.text_name);
        key_word = findViewById(R.id.key_word);
        key_num = findViewById(R.id.key_num);

        btn_ENTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key = Integer.valueOf(key_num.getText().toString());
                String name = edit_name.getText().toString();
                String keyword = key_word.getText().toString();

                String encryptedString = encrypt(name, keyword, key);
                text_name.setText(encryptedString.toLowerCase());
            }
        });

    }

    public static String encrypt(String name, String keyword, int key_Index) {
        name = name.toUpperCase();
        keyword = keyword.toUpperCase();

        String alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        StringBuilder encryptedMessage = new StringBuilder();


        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (!Character.isLetter(c)) {
                encryptedMessage.append(c);
                continue;
            }

            int keywordShift = alphabet.indexOf(keyword.charAt(key_Index));
            int messageShift = alphabet.indexOf(c);

            int encryptedShift = (keywordShift + messageShift) % alphabet.length();

            encryptedMessage.append(alphabet.charAt(encryptedShift));

            key_Index = (key_Index + 1) % keyword.length();
        }

        return encryptedMessage.toString();
    }


}