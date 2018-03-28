package com.example.filip.bestbeer;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by filip on 25/03/2018.
 */

public class Beer implements Serializable {
    public double mls =0;
    public double price =0;
    public double media =0;
    public boolean valida;
    public int position;
    public String name;

    public Beer() {

    }

    public Beer(double mls, double price, double media, boolean valida, int position) {
        this.mls = mls;
        this.price = price;
        this.media = media;
        this.valida = valida;
        this.position = position;
    }

    public static void toastZeroValuesBeer(int position, Activity context) {
        Context contexto = context.getApplicationContext();
        String txt = "Valor(es) na cerveja " + position + " não podem ser zero";
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto,txt,duracao);
        toast.show();
    }

    public static void toastEmptyValuesBeer(int position, Activity context) {
        Context contexto = context.getApplicationContext();
        String txt = "Campo(s) vazio(s) na cerveja " + position;
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto,txt,duracao);
        toast.show();
    }

    public static void bubbleSort(Beer beers[]) {
        for (int i = beers.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (beers[j - 1].media < beers[j].media) {
                    Beer aux = beers[j];
                    beers[j] = beers[j - 1];
                    beers[j - 1] = aux;
                }
            }
        }
    }


}
