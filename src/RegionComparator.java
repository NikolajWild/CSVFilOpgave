import java.util.Comparator;

public class RegionComparator implements Comparator<Nøgletal> {
    // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
    public int compare(Nøgletal d1, Nøgletal d2) {
        return d1.getRegion().compareTo(d2.getRegion());

    }

}
