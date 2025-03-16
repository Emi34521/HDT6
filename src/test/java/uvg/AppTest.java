package uvg;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testAddPokemon() {
        UserCollection uc = new UserCollection();
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "Electric", "", Arrays.asList("Static", "Lightning Rod")));

        uc.addPokemon("Pikachu", pokemonMap);
        
        assertEquals(1, uc.getUserPokemons().size(), "El Pokémon debería agregarse correctamente.");
    }

    @Test
    void testAddDuplicatePokemon() {
        UserCollection uc = new UserCollection();
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "Electric", "", Arrays.asList("Static", "Lightning Rod")));

        uc.addPokemon("Pikachu", pokemonMap);
        uc.addPokemon("Pikachu", pokemonMap); // Intentamos agregarlo de nuevo
        
        assertEquals(1, uc.getUserPokemons().size(), "No debería permitir duplicados.");
    }

    @Test
    void testAddNonExistentPokemon() {
        UserCollection uc = new UserCollection();
        Map<String, Pokemon> pokemonMap = new HashMap<>(); // Mapa vacío

        uc.addPokemon("Mewtwo", pokemonMap); // No existe en el mapa
        
        assertEquals(0, uc.getUserPokemons().size(), "No debería agregarse un Pokémon que no existe en el CSV.");
    }

}