package com.example.stakemines;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageButton imgbtn[] =new ImageButton[16];
    Boolean game = true;
    Integer gameCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgbtn[0] = findViewById(R.id.img1);
        imgbtn[1] = findViewById(R.id.img2);
        imgbtn[2] = findViewById(R.id.img3);
        imgbtn[3] = findViewById(R.id.img4);
        imgbtn[4] = findViewById(R.id.img5);
        imgbtn[5] = findViewById(R.id.img6);
        imgbtn[6] = findViewById(R.id.img7);
        imgbtn[7] = findViewById(R.id.img8);
        imgbtn[8] = findViewById(R.id.img9);
        imgbtn[9] = findViewById(R.id.img10);
        imgbtn[10] = findViewById(R.id.img11);
        imgbtn[11] = findViewById(R.id.img12);
        imgbtn[12] = findViewById(R.id.img13);
        imgbtn[13] = findViewById(R.id.img14);
        imgbtn[14] = findViewById(R.id.img15);
        imgbtn[15] = findViewById(R.id.img16);

        Random random = new Random();
        int randomNumber1 = random.nextInt(16);
        int randomNumber2 = random.nextInt(16);
        int randomNumber3 = random.nextInt(16);
        int randomNumber4 = random.nextInt(16);

        Log.i("randomNUmber", String.valueOf(randomNumber1));
        Log.i("randomNUmber", String.valueOf(randomNumber2));
        Log.i("randomNUmber", String.valueOf(randomNumber3));
        Log.i("randomNUmber", String.valueOf(randomNumber4));

        for(int i=0;i< imgbtn.length;i++)
        {
            int finalI = i+1;
            imgbtn[i].setOnClickListener(view -> play(view,finalI,randomNumber1,randomNumber2,randomNumber3,randomNumber4));
        }

    }

    private void play(View view,int buttonNumber,int randomNumber1,int randomNumber2,int randomNumber3,int randomNumber4 )
    {
        ImageButton btnClick =findViewById(view.getId());

        gameCounter++;

        if(btnClick.getBackground().toString().contains("Ripple") && game==true) {


            if (buttonNumber != randomNumber1 && buttonNumber!= randomNumber2 && buttonNumber != randomNumber3 && buttonNumber != randomNumber4) {

                btnClick.setBackground(getDrawable(R.drawable.twotone_diamond_24));

            } else {


                btnClick.setBackground(getDrawable((R.drawable.twotone_cruelty_free_24)));
                game = false;
                Toast.makeText(getApplicationContext(),"gameOver",Toast.LENGTH_LONG).show();
            }


        }

        if(gameCounter >= 12 && game==true){
            game = false;
            Toast.makeText(getApplicationContext(),"You win",Toast.LENGTH_LONG).show();

        }
    }
}