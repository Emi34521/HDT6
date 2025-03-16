package uvg;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserCollection {
    private List<Pokemon> userPokemons = new ArrayList<>();

    public void addPokemon(String name, Map<String, Pokemon> pokemonMap) {
        if (userPokemons.stream().anyMatch(p -> p.getName().equals(name))) {
            System.out.println("Este Pokémon ya está en tu colección.");
        } else if (pokemonMap.containsKey(name)) {
            userPokemons.add(pokemonMap.get(name));
            System.out.println(name + " agregado a tu colección.");
        } else {
            System.out.println("El Pokémon no existe en los datos.");
        }
    }

    public void showPokemonData(String name, Map<String, Pokemon> pokemonMap) {
        System.out.println(pokemonMap.getOrDefault(name, new Pokemon("No encontrado", "N/A", "N/A", new ArrayList<>())));
    }

    public void showUserPokemonsSorted() {
        userPokemons.stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(System.out::println);
    }
    // **Nuevo método getter**
    public List<Pokemon> getUserPokemons() {
        return userPokemons;
    }
}