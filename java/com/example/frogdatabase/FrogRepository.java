package com.example.frogdatabase;


import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FrogRepository {

    private static FrogRepository instance;
    private List<Frog> mFrogs;

    public static FrogRepository getInstance(Context context) {
        if (instance == null) {
            instance = new FrogRepository(context);
        }
        return instance;
    }

    private FrogRepository(Context context) {
        mFrogs = new ArrayList<>();
        //Resources res = context.getResources();
        //String[] frogs = res.getStringArray(R.array.frogs);
        //String[] descriptions = res.getStringArray(R.array.descriptions);
        //for (int i = 0; i < frogs.length; i++) {
        //    mFrogs.add(new Frog(i + 1, frogs[i], descriptions[i]));
        //}


        InputStream is = context.getResources().openRawResource(R.raw.frogs);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        int count = 1; //for id of frogs
        while(true){
            try {
                if (!((line = reader.readLine()) != null)) break;
                //split by commas ','
                String[] tokens = line.split(",");
                //read the data
                Frog frog = new Frog();
                frog.setName(tokens[0]);
                frog.setmAddress(tokens[3] + tokens[4] + tokens[5]);
                frog.setId(count);
                count++;
                frog.setDescription("Temp" + count);
                //frog.setLatitude(Double.parseDouble(tokens[1]));
                //frog.setLongitude(Double.parseDouble(tokens[2]));
                mFrogs.add(frog);
            } catch (IOException e) {
                Log.wtf("Repository", "Error reading frogs!" + line, e);
                e.printStackTrace();
            }

        }

    }

    public List<Frog> getFrogs() {
        return mFrogs;
    }

    public Frog getFrog(int frogId) {
        for (Frog frog : mFrogs) {
            if (frog.getId() == frogId) {
                return frog;
            }
        }
        return null;
    }
}
