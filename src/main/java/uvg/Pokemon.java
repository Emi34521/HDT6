package uvg;

import java.util.List;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private List<String> abilities;

    public Pokemon(String name, String type1, String type2, List<String> abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2.isEmpty() ? "None" : type2;
        this.abilities = abilities;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public List<String> getAbilities() { return abilities; }

    @Override
    public String toString() {
        return name + " - Tipo: " + type1 + (type2.equals("None") ? "" : ", " + type2) +
               " - Habilidades: " + String.join(", ", abilities);
    }
}