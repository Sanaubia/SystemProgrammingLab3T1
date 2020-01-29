import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ThreadHTTP extends Thread{

    private String address;

    public ThreadHTTP(String address){
        this.address = address;
    }

    @Override
    public void run() {
        //System.out.println("Osoite on " + address);
        try {
            URL url = new URL("https://"+ address);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream stream = urlConnection.getInputStream();
            String result = fromStream(stream);
            //Log.d("LUENTO2", result);
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }


}