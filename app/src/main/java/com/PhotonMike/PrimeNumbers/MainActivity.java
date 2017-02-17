package com.PhotonMike.PrimeNumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText betext = (EditText) findViewById(R.id.betext);
                TextView kimenet = (TextView) findViewById(R.id.kimenet);
                kimenet.setText("");
                int prim = 1;
                int veg = 0;
                boolean a = true;
                try
                {
                    veg = Integer.parseInt(betext.getText().toString());
                }
                catch(Exception e)
                {
                    kimenet.setText("@string/number_in");
                    a=false;
                }
                if (a) {
                    for (int i = 0; i <= veg; ) {
                        if (isprime(prim)) {
                            kimenet.append(Integer.toString(prim) + "\r\n");
                            i++;
                        }
                        prim++;

                    }
                }
            }
        });
    }

    public static boolean isprime(int a)
    {
        int b;
        b = 2;
        if (a == 1) { return false; }
        if (a == 2) { return true; }
        boolean i;
        i = false;
        while (!i)
        {
            if (a % b == 0)
            {
                i = true;
            }
            else
            {
                if (b >= Math.sqrt(a))
                {
                    return true;
                }
                else
                {
                    b = b + 1;
                }
            }

        }
        return false;
    }
}
