import java.util.Scanner;

public class HttpRequ {
    public static void main(String[] args){

        askWeather();
    }

    private static void askWeather(){
        int i = 0;
        String address;
        Scanner in = new Scanner(System.in);
       
       //ThreadHTTP http = new ThreadHTTP();
        
        while (i < 1){
            System.out.println("Syötä osoite:");
            address = in.nextLine();
            //http(address).start();

            ThreadHTTP http = new ThreadHTTP(address);
            http.start();
            i = 1;
    
        }

    }
}