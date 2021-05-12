package sample;

import java.net.*;
import java.io.*;

public class city {
    public String getData(String city) {
        String output = getUrlContents("https://api.covid19india.org/state_district_wise.json",city);
        System.out.println(output);
        return output;
    }

    private String getUrlContents(String s,String p) {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try {
            // create a url object

            String theUrl = s;
            URL url = new URL(theUrl);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String aString =  content.toString();
        int i = aString.indexOf(p,0);
        System.out.println(i);

        int i1 = aString.indexOf("active",i);
        int index1 = aString.indexOf(':',i1);
        int index12 = aString.indexOf(',',index1);
        String active = aString.substring(index1+1,index12);

        int i2 = aString.indexOf("recovered",i1);
        int index2 = aString.indexOf(':',i2);
        int index22 = aString.indexOf(',',index2);
        String recovered = aString.substring(index2+1,index22);

        int i3 = aString.indexOf("confirmed",i1);
        int index3 = aString.indexOf(':',i3);
        int index32 = aString.indexOf(',',index3);
        String confirmed = aString.substring(index3+1,index32);

        System.out.println("Active cases :"+active);
        System.out.println("confirmed :"+confirmed);
        System.out.println("Recovered :"+recovered);

        return aString;
    }


}

