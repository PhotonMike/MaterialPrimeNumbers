package com.PhotonMike.PrimeNumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {

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
            if (isprime(prim))
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
    public void arraytostring()
    {
        for (ciklus = 1; ciklus < veg; ciklus++)
        {
            kiir.append(Integer.toString(eredmeny[ciklus]) + "\r\n");
        }
    }
    void updateOutput(final String out)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                kimenet.setText(out);
            }
        });
    }
    public void mainProgram() throws InterruptedException {
        updateOutput("");
        kiir.delete(0,kiir.length());
        try
        {
            veg = Integer.parseInt(betext.getText().toString())+1;
        }
        catch(Exception e)
        {
            updateOutput(getString(R.string.number_in));
            veg=1;
        }
            Thread szal = new Thread(new Runnable() {
                //@Override
                public void run() {
                    primelist();
                }
            });
            szal.start();
            //toltes.setMax(vege);
            while (!szal.isAlive())
            {
                updateOutput(getString(R.string.threadstart));
            }
            while (szal.isAlive())
            {
                updateOutput(getString(R.string.wait)+"("+Integer.toString(ciklus-1)+"/"+Integer.toString(veg-1)+")");
                Thread.sleep(10);
                //toltes.Value = ciklus;
                //toltes.Update();
            }
            //kimenet.setText("");
            Thread szal2 = new Thread(new Runnable() {
                //@Override
                public void run() {
                    arraytostring();
                }
            });
            szal2.start();
            while (!szal2.isAlive())
            {
                updateOutput(getString(R.string.threadstart));
            }
            while (szal2.isAlive())
            {
                updateOutput(getString(R.string.merge)+"("+Integer.toString(ciklus-1)+"/"+Integer.toString(veg-1)+")");
                Thread.sleep(10);
                //toltes.Value = ciklus;
                //toltes.Update();
            }
            updateOutput(kiir.toString());
    }
    EditText betext;
    TextView kimenet;
    ProgressBar toltes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button1);
        betext = (EditText) findViewById(R.id.betext);
        kimenet = (TextView) findViewById(R.id.kimenet);
        toltes = (ProgressBar) findViewById(R.id.toltes);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread szalacska = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mainProgram();
                        } catch (InterruptedException e) {}
                    }
                });
                szalacska.start();
            }
        });
    }

}
