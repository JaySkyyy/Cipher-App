package appcr.ushakov.cipherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCaesar = (Button)findViewById(R.id.btnCaesar);
        btnCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, CaesarCipher.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Button btnCaesarMod = (Button) findViewById(R.id.btnCaesarMod);
        btnCaesarMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, CaesarModCipher.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Button btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, ChangeCipher.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }
}