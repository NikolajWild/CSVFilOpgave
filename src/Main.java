import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        Scanner scan = new Scanner(System.in);
        //choice er = minus et så den ikke er lig nogle af menu mulighederne
        int choice = -1;
        //loader coviddata fra filen
        ArrayList<Nøgletal> covidTal = fh.loadNøgletal();
        int sentinel = 4;
        System.out.println("Dette program viser covid19 data.");
        System.out.println("Tast 1 for at se det i usorteret form");
        System.out.println("Tast 2 for at se dataen sorteret efter regioner");
        System.out.println("Tast 3 for at se dataen sorteret efter aldersgruppe");
        System.out.println("Tast 4 for at afslutte programmet");

        //Imens choice ikke er = med sentinel så gå den ind i while loopet, choice er ligesom før fra start sat til -1 så den ikke påvirker sentinel
        while(choice != sentinel){
            //choice er blevet vores scanner input som her bruger integer.parseint til at tage et tal istedet for en string for at navigere i menuen
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    // display coviddata, viser den originale fil uden nogen sortering
                    for (Nøgletal nøgletal : covidTal) {
                        System.out.println(covidTal);
                    }
                    break;
                case 2:
                    //her bruger jeg min region comparator, og sortere derfor cvs filen ud fra region.
                    System.out.println("Sortering efter region");
                    covidTal.sort(new RegionComparator().thenComparing(Nøgletal::getAldersGruppe));
                    for (Nøgletal nt : covidTal) {
                        System.out.println(nt.getRegion() + ": " + nt.getAldersGruppe()+": "+nt.getBekræftedeTilfældeIAlt()+ ": " + nt.getDøde()+": "+ ": " + nt.getIndlagtePåIntensivAfdeling()
                                        + ":" + nt.getIndlagte()+": "+ nt.getDato());
                    }
                    break;
                case 3:
                    //Samme som ovenover istedet ud fra aldersgruppe.
                    System.out.println("Sortering efter aldersgruppe");
                    //sortere først min arrayliste ved at Bruge min aldersgruppeComparator og tilføjer then comparing så den først sortere efter aldersgruppe og herefter region
                    covidTal.sort(new AldersgruppeComparator().thenComparing(Nøgletal::getRegion));
                    for (Nøgletal nt : covidTal) {
                        System.out.println(nt.getAldersGruppe() + ": " + nt.getRegion()+": "+nt.getBekræftedeTilfældeIAlt()+ ": " + nt.getDøde()+": "+ ": " + nt.getIndlagtePåIntensivAfdeling()
                                + ":" + nt.getIndlagte()+": "+ nt.getDato());

                    }
                    break;
                case 4:
                    //Her stopper programmet da min sentinel er sat til 4
                    System.out.println("Du har nu afsluttet programmet.");
            }
        }
    }
}
