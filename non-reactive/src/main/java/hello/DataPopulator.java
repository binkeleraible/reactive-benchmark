package hello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataPopulator {


    private static final List<String> NAMES = Arrays.asList("Bob", "Fred", "Heinrich", "John",
            "Noman", "Raimund", "Ankit", "Patrick", "Thomas", "Kyril",
            "Dirk", "Stefan", "Hugo", "Chris", "Sepp", "Josef", "Franz", "Mischa", "Hubert", "Horst", "Norbert", "David",
            "Manuel", "Christian", "Thorsten", "Espen", "Brian"
    );
    private static final List<String> ADJECTIVES = Arrays.asList("joyful", "painful", "smart", "beloved", "boring",
            "nice", "cruel", "hopeless", "jealous", "freaky", "lazy", "quick", "stormy", "ruthless", "heavy", "cheerful",
            "underestimated", "sweet", "bitter", "spicy", "hot", "sunny", "cloudy", "respectfull"
    );

    public static void main(String[] args) {

    }

    static String randomName(){
        int idx = new Random().nextInt(NAMES.size());
        return NAMES.get(idx);
    }

    static String randomAdjective(){
        int idx = new Random().nextInt(ADJECTIVES.size());
        return ADJECTIVES.get(idx);
    }
}
