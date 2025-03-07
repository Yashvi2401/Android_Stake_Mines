package com.example.stakemines;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    ImageButton imgbtn[] =new ImageButton[16];


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

        for(int i=0;i< imgbtn.length;i++)
        {
            int finalI = i+1;
            imgbtn[i].setOnClickListener(view -> play(view,finalI));
        }

    }

    private void play(View view,int buttonNumber)
    {
        ImageButton btnClick =findViewById(view.getId());

        if(btnClick.getBackground().toString().contains("Ripple")){

            btnClick.setBackground(getDrawable(R.drawable.twotone_diamond_24));

        }
    }
}