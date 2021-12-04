package com.example.evaluacioncontinua2.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.evaluacioncontinua2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersonEntry {

    private static final String TAG = PersonEntry.class.getSimpleName();

    public final String Name;
    public final Uri DynamicUrl;
    public final String Url;
    public final String Age;
    public final String Country;

    public PersonEntry(String name, Uri dynamicUrl, String url, String age, String country) {

        Name = name;
        DynamicUrl = dynamicUrl;
        Url = url;
        Age = age;
        Country = country;
    }

    public static List<PersonEntry> initPersonEntryList(Resources resources){

        InputStream inputStream = resources.openRawResource(R.raw.person);

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            int pointer;

            while((pointer = reader.read(buffer)) != -1){

                writer.write(buffer, 0, pointer);
            }
        }catch (IOException e){

            Log.e(TAG, "Error al escribir o leer el archivo JSON", e);

        }finally {

            try {
                inputStream.close();

            }catch (IOException e){

                Log.e(TAG, "Error al cerrar la conexion con el archivo", e);
            }
        }
        String jsonPersonString = writer.toString();

        Gson gson = new Gson();

        Type personListType = new TypeToken<ArrayList<PersonEntry>>(){
        }.getType();

        return gson.fromJson(jsonPersonString, personListType);
    }
}
