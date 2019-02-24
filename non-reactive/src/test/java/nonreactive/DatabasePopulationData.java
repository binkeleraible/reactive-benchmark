package nonreactive;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DatabasePopulationData {

    private static final List<String> NAMES = Arrays.asList("Bob", "Fred", "Heinrich", "John",
            "Noman", "Raimund", "Ankit", "Patrick", "Thomas", "Kyril",
            "Dirk", "Stefan", "Hugo", "Chris", "Sepp", "Josef", "Franz", "Mischa", "Hubert", "Horst", "Norbert", "David",
            "Manuel", "Christian", "Thorsten", "Espen", "Brian", "Frederik", "Kimi", "Michael", "Mathew", "Milan",
            "Manfred", "Sebastian", "Markus", "Dieter", "Eberhard", "Henning", "Bruce", "Tom", "George", "Robert",
            "Paul", "Richard", "Keith", "Steven", "Cliff", "Jeremy", "Vladimir", "Giuseppe"
    );
    private static final List<String> ADJECTIVES = Arrays.asList("joyful", "painful", "smart", "beloved", "boring",
            "nice", "cruel", "hopeless", "jealous", "freaky", "lazy", "quick", "stormy", "ruthless", "heavy", "cheerful",
            "underestimated", "sweet", "bitter", "spicy", "hot", "sunny", "cloudy", "respectful", "noisy", "loud",
            "waving", "unkown", "pleasant", "amazing", "joyful", "nostalgic", "unbearable", "disguised", "smelling",
            "untrusted", "tiny", "stupid", "hidden", "light", "sleeping", "tasting", "crying", "wheeping", "praying",
            "running", "spinning", "twisting", "rushing", "sitting", "bathing", "watching", "pushing"
    );

    static String randomName(){
        int idx = new Random().nextInt(NAMES.size());
        return NAMES.get(idx);
    }

    static String randomAppelation(){
        int idx = new Random().nextInt(ADJECTIVES.size());
        return ADJECTIVES.get(idx);
    }
}
