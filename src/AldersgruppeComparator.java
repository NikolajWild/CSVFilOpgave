import java.util.Comparator;
//aldersgruppe comparator implementere comparator og bruger nøgletal da det er her dataen bliver deklaret fra min nøgletalsklasse
public class AldersgruppeComparator implements Comparator<Nøgletal>{
    // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
        public int compare(Nøgletal d1, Nøgletal d2) {
            return d1.getAldersGruppe().compareTo(d2.getAldersGruppe());

        }

    }


