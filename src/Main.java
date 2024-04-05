import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            FileHandler fh = new FileHandler();

            //loader coviddata fra filen
            ArrayList<Nøgletal> covidTal = fh.loadNøgletal();

            // display coviddata
            for (Nøgletal nøgletal: covidTal) {
                System.out.println(covidTal);
            }
        }
    }
