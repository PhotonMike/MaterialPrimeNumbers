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
                    veg = Integer.parseInt(betext.getText().toString())+1;
                }
                catch(Exception e)
                {
                    kimenet.setText("@string/number_in");
                    a=false;
                    veg=1;
                }
                if (a) {
                    Thread szal = new Thread(new ThreadStart(primelist)) ;
                    szal.Start();
                    toltes.Maximum = vege;
                    while (!szal.IsAlive)
                    {
                        kimenet.Text = "Szál inditása";
                        kimenet.Update();
                    }
                    while (szal.IsAlive)
                    {
                        kimenet.Text = "Várakozás az eredményre ("+Convert.ToString(ciklus)+"/"+Convert.ToString(vege)+")";
                        kimenet.Update();
                        toltes.Value = ciklus;
                        toltes.Update();
                    }
                    kimenet.Text = "";
                    Thread szal2 = new Thread(new ThreadStart(arraytostring));
                    szal2.Start();
                    while (!szal2.IsAlive)
                    {
                        kimenet.Text = "Szál inditása";
                        kimenet.Update();
                    }
                    while (szal2.IsAlive)
                    {
                        kimenet.Text = "Várakozás az eredményre (" + Convert.ToString(ciklus) + "/" + Convert.ToString(vege) + ")";
                        kimenet.Update();
                        toltes.Value = ciklus;
                        toltes.Update();
                    }
                    kimenet.Text = Convert.ToString(kiir);
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
    public static void primelist()
    {
        int prim = 1;
        eredmeny = new int[veg];
        for (ciklus = 0; ciklus < veg;)
        {
            if (isprime(prim) == true)
            {
                eredmeny[ciklus] = prim;
                ciklus++;
            }
            prim++;

        }
    }
    public static int vege = 0;
    public static int[] eredmeny;
    public static int veg, ciklus;
    public static StringBuilder kiir = new StringBuilder("");
    public static void arraytostring()
    {
        for (ciklus = 1; ciklus < vege; ciklus++)
        {
            kiir.append(Integer.toString(eredmeny[ciklus]) + "\r\n");
        }
    }
}
