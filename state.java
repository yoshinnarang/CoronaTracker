
package sample;

import java.net.*;
import java.io.*;

public class state  {
    public String getData(String state) {
        String output = getUrlContents("https://api.covid19india.org/csv/latest/state_wise.csv",state);
        System.out.println(output);
        return output;
    }

    private String getUrlContents(String s, String p) {
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
        int i1 = aString.indexOf(",",i);
        int index1 = aString.indexOf(',',i1+1);
        String confirmed = aString.substring(i1+1,index1);
        int i2 = aString.indexOf(',',index1);
        int index2 = aString.indexOf(',',i2+1);
        String recovered = aString.substring(i2+1,index2);

        int i3 = aString.indexOf(',',index2);
        int index3 = aString.indexOf(',',i3+1);
        String deaths = aString.substring(i3+1,index3);

        int i4 = aString.indexOf(',',index3);
        int index4 = aString.indexOf(',',i4+1);
        String Active = aString.substring(i4+1,index4);



        System.out.println("Active cases :"+Active);
        System.out.println("Deaths :"+deaths);
        System.out.println("Recovered :"+recovered);
        System.out.println("Confirmed :"+confirmed);

        return aString;
    }


}
