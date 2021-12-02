package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[][] a={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    int k=0;
    public void fade(View view)
    {
        k=0;
        ImageView i1=(ImageView)findViewById(R.id.g1);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g2);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g3);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g4);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g5);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g6);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g7);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g8);
        i1.animate().alpha(0);
        i1=(ImageView)findViewById(R.id.g9);
        i1.animate().alpha(0);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]=-1;
            }
        }
    }
    public void repeat()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]=0;
            }
        }
    }
    public boolean conti()
    {
        int c=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(a[i][j]==-1)
                {
                    c++;
                }
            }
        }
        if(c<=1)
        {
            return true;
        }
        return false;
    }
    public boolean check()
    {

        if(a[0][0]!=-1 && ((a[0][0]==a[1][0] && a[2][0]==a[0][0])||(a[0][0]==a[0][1] && a[0][2]==a[0][0])))
        {
            return true;
        }
        if(a[1][1]!=-1 && ((a[1][1]==a[1][0] && a[1][2]==a[1][1])||(a[1][1]==a[0][1] && a[2][1]==a[1][1])))
        {
            return true;
        }
        if(a[2][2]!=-1 && ((a[2][2]==a[2][0] && a[2][1]==a[2][2])||(a[2][2]==a[0][2] && a[1][2]==a[2][2])))
        {
            return true;
        }
        if(a[1][1]!=-1 && ((a[0][0]==a[1][1] && a[2][2]==a[1][1])||(a[1][1]==a[2][0] && a[1][1]==a[0][2])))
        {
            return true;
        }
        if(conti())
        {
            repeat();
            Toast.makeText(this, "Game is Drawn!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    public void press(View view)
    {
        ImageView i1=(ImageView)view;
        String s1=view.getTag().toString();
        int p1=Integer.parseInt(s1);
        int i=(p1-1)/3;
        int j=(p1-1)%3;
        if(a[i][j]!=-1)
        {
            Toast.makeText(this, "Operation Invalid!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(k==0)
        {
            i1.setImageResource(R.drawable.cross);
            i1.animate().alpha(1);
            a[i][j]=0;
            k=1;
        }
        else {
            i1.setImageResource(R.drawable.circle);
            i1.animate().alpha(1);
            a[i][j]=1;
            k = 0;
        }
        if(check()==true)
        {
            if(k==0)
            {
                Toast.makeText(this, "Congratulations!Dot player Won", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Congratulations!Cross player Won", Toast.LENGTH_SHORT).show();
            }
            repeat();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}