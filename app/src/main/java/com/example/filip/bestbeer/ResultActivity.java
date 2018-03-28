package com.example.filip.bestbeer;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView bestBeer, sndBeer, trdBeer, fthBeer;
    TextView fstQtd, fstPreco, fstMedia;
    TextView sndMedia, trdMedia, fthMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Beer[] orderBeers = new Beer[4];
        Beer beerOne = (Beer) getIntent().getSerializableExtra("beerOne");
        beerOne.name = getString(R.string.cerveja_1);

        Beer beerTwo = (Beer) getIntent().getSerializableExtra("beerTwo");
        beerTwo.name = getString(R.string.cerveja_2);

        Beer beerThree = (Beer) getIntent().getSerializableExtra("beerThree");
        beerThree.name = getString(R.string.cerveja_3);

        Beer beerFour = (Beer) getIntent().getSerializableExtra("beerFour");
        beerFour.name = getString(R.string.cerveja_4);

        orderBeers[0] = beerOne;
        orderBeers[1] =  beerTwo;
        orderBeers[2] = beerThree;
        orderBeers[3] =  beerFour;

        Beer.bubbleSort(orderBeers);

        bestBeer = (TextView) findViewById(R.id.bestBeer);
        fstQtd = (TextView) findViewById(R.id.fstQtd);
        fstPreco = (TextView) findViewById(R.id.fstPreco);
        fstMedia= (TextView) findViewById(R.id.fstMedia);

        sndBeer = (TextView) findViewById(R.id.sndBeer);
        trdBeer = (TextView) findViewById(R.id.trdBeer);
        fthBeer = (TextView) findViewById(R.id.fthBeer);

        sndMedia = (TextView) findViewById(R.id.sndMedia);
        trdMedia = (TextView) findViewById(R.id.trdMedia);
        fthMedia= (TextView) findViewById(R.id.fthMedia);
        //-----------------------------------------------------------------------
        bestBeer.setText(String.valueOf(orderBeers[0].name));
        fstMedia.setText(String.valueOf(String.format("%.2f",orderBeers[0].media)));
        fstQtd.setText(String.valueOf(orderBeers[0].mls));
        fstPreco.setText(String.valueOf(orderBeers[0].price));

        sndBeer.setText(String.valueOf(orderBeers[1].name));
        trdBeer.setText(String.valueOf(orderBeers[2].name));
        fthBeer.setText(String.valueOf(orderBeers[3].name));

        sndMedia.setText(String.valueOf(getString(R.string.media) + " " + String.format("%.2f",orderBeers[1].media)));
        trdMedia.setText(String.valueOf(getString(R.string.media) + " " + String.format("%.2f",orderBeers[2].media)));
        fthMedia.setText(String.valueOf(getString(R.string.media) + " " + String.format("%.2f",orderBeers[3].media)));
    }
}
