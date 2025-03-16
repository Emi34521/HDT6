package uvg;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CSVLoader {
    public void loadCSV(Map<String, Pokemon> pokemonMap, String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            br.readLine(); // Saltar encabezado

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String name = fields[0].trim();
                String type1 = fields[2].trim();
                String type2 = fields[3].trim();
                List<String> abilities = Arrays.asList(fields[7].replace("\"", "").split(", "));

                pokemonMap.put(name, new Pokemon(name, type1, type2, abilities));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllPokemonsByType(Map<String, Pokemon> pokemonMap) {
        pokemonMap.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(System.out::println);
    }

    public void findPokemonByAbility(Map<String, Pokemon> pokemonMap, String ability) {
        pokemonMap.values().stream()
                .filter(p -> p.getAbilities().contains(ability))
                .forEach(System.out::println);
    }
}