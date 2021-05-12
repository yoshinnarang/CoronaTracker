package sample;

import java.net.*;
import java.io.*;

public class Data  {
    public String getData(String countryName) {
        String output = getUrlContents("https://coronavirus-19-api.herokuapp.com/countries/"+countryName,countryName);
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

        int i1 = aString.indexOf("deaths",i);
        int index1 = aString.indexOf(':',i1);
        int index12 = aString.indexOf(',',index1);
        String deaths = aString.substring(index1+1,index12);

        int i2 = aString.indexOf("recovered",i1);
        int index2 = aString.indexOf(':',i2);
        int index22 = aString.indexOf(',',index2);
        String recovered = aString.substring(index2+1,index22);

//        int i3 = aString.indexOf("active",i2);
//        int index3 = aString.indexOf(':',i3);
//        int index32 = aString.indexOf(',',index3);
//        String Active = aString.substring(index3+1,index32);




//        System.out.println("Active cases :"+Active);
        System.out.println("Deaths :"+deaths);
        System.out.println("Recovered :"+recovered);

        return aString;
    }


}
