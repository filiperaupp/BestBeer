package com.example.filip.bestbeer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;

    EditText[] edMls = new EditText[4];
    EditText[] edPrices = new EditText[4];
    double[] beerMls = new double[4];
    double[] beerPrices = new double[4];
    double[] beerMedia = new double[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Linkando botões com XML
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        edMls[0] = (EditText) findViewById(R.id.qtd_beer_1);
        edMls[1] = (EditText) findViewById(R.id.qtd_beer_2);
        edMls[2] = (EditText) findViewById(R.id.qtd_beer_3);
        edMls[3] = (EditText) findViewById(R.id.qtd_beer_4);
        edPrices[0] = (EditText) findViewById(R.id.price_beer_1);
        edPrices[1] = (EditText) findViewById(R.id.price_beer_2);
        edPrices[2] = (EditText) findViewById(R.id.price_beer_3);
        edPrices[3] = (EditText) findViewById(R.id.price_beer_4);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contBeers = 0;
                boolean[] valida = new boolean[4];
                //-------------CERVEJA 1------------------
                try {
                    beerMls[0] = Double.parseDouble(edMls[0].getText().toString());
                    beerPrices[0] = Double.parseDouble(edPrices[0].getText().toString());
                    beerMedia[0] = beerMls[0]/beerPrices[0];
                    valida[0]=true;
                }
                catch (Exception e) {
                }
                //-------------CERVEJA 2------------------
                try {
                    beerMls[1] = Double.parseDouble(edMls[1].getText().toString());
                    beerPrices[1] = Double.parseDouble(edPrices[1].getText().toString());
                    beerMedia[1] = beerMls[1]/beerPrices[1];
                    valida[1]=true;
                }
                catch (Exception e) {
                }
                //-------------CERVEJA 3------------------
                try {
                    beerMls[2] = Double.parseDouble(edMls[2].getText().toString());
                    beerPrices[2] = Double.parseDouble(edPrices[2].getText().toString());
                    beerMedia[2] = beerMls[2]/beerPrices[2];
                    valida[2]=true;
                }
                catch (Exception e) {
                }
                //-------------CERVEJA 4------------------
                try {
                    beerMls[3] = Double.parseDouble(edMls[3].getText().toString());
                    beerPrices[3] = Double.parseDouble(edPrices[3].getText().toString());
                    beerMedia[3] = beerMls[3]/beerPrices[3];
                    valida[3]=true;
                }
                catch (Exception e) {
                }
                //-------------VERIFICA CALCULOS------------------
                for (Boolean iten:valida) {
                    if (iten==true) {
                        contBeers++;
                    }
                }
                if (contBeers<2) {
                    Context contexto = getApplicationContext();
                    String txt = "Preencha no mínimo duas cervejas ";
                    int duracao = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(contexto,txt,duracao);
                    toast.show();
                    for (Boolean iten:valida) {
                        iten = false;
                    }
                } else {
                    //----VALIDAÇÃO CERVEJA 1------------------
                    if(valida[0]==true && (beerMls[0]==0 || beerPrices[0]==0.0)) {
                        Beer.toastZeroValuesBeer(1,MainActivity.this);
                    }else if(valida[0]==false && ((beerMls[0]!=0 && beerPrices[0]>=0.0) || (beerMls[0]>=0 && beerPrices[0]!=0))) {
                        Beer.toastEmptyValuesBeer(1,MainActivity.this);
                    }
                    //----VALIDAÇÃO CERVEJA 2------------------
                    else if (valida[1]==true && (beerMls[1]==0 || beerPrices[1]==0)) {
                        Beer.toastZeroValuesBeer(2,MainActivity.this);
                    }else if(valida[1]==false && ((beerMls[1]!=0 && beerPrices[1]>=0.0) || (beerMls[1]>=0 && beerPrices[1]!=0))) {
                        Beer.toastEmptyValuesBeer(2,MainActivity.this);
                    }
                    //----VALIDAÇÃO CERVEJA 3------------------
                    else if (valida[2]==true && (beerMls[2]==0 || beerPrices[2]==0)) {
                        Beer.toastZeroValuesBeer(3,MainActivity.this);
                    }else if(valida[2]==false && ((beerMls[2]!=0 && beerPrices[2]>=0.0) || (beerMls[2]>=0 && beerPrices[2]!=0))) {
                        Beer.toastEmptyValuesBeer(3,MainActivity.this);
                    }
                    //----VALIDAÇÃO CERVEJA 4------------------
                    else if (valida[3]==true && (beerMls[3]==0 || beerPrices[3]==0)) {
                        Beer.toastZeroValuesBeer(4,MainActivity.this);
                    }else if(valida[3]==false && ((beerMls[3]!=0 && beerPrices[3]>=0.0) || (beerMls[3]>=0 && beerPrices[3]!=0))) {
                        Beer.toastEmptyValuesBeer(4,MainActivity.this);
                    }
                    //----FINALMENTE---------------------------
                    else {
                        Beer beerOne = new Beer(beerMls[0],beerPrices[0],beerMedia[0],valida[0],1);
                        Beer beerTwo = new Beer(beerMls[1],beerPrices[1],beerMedia[1],valida[1],2);
                        Beer beerThree = new Beer(beerMls[2],beerPrices[2],beerMedia[2],valida[2],3);
                        Beer beerFour= new Beer(beerMls[3],beerPrices[3],beerMedia[3],valida[3],4);

                        Intent intentToResult = new Intent(MainActivity.this, ResultActivity.class);
                        intentToResult.putExtra("beerOne", beerOne);
                        intentToResult.putExtra("beerTwo", beerTwo);
                        intentToResult.putExtra("beerThree", beerThree);
                        intentToResult.putExtra("beerFour", beerFour);
                        intentToResult.putExtra("totalBeers",contBeers);
                        MainActivity.this.startActivity(intentToResult);
                        }
                    }
                }
        });

    }
}
