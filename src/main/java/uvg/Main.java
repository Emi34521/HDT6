package uvg;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner md = new Scanner(System.in);

        // Seleccionar el tipo de Map
        System.out.println("Seleccione el tipo de Map: 1) HashMap, 2) TreeMap, 3) LinkedHashMap");
        int opcion = md.nextInt();
        md.nextLine(); // Limpiar buffer

        Map<String, Pokemon> pokemonMap = MapFactory.createMap(opcion);
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.loadCSV(pokemonMap, "Pokemones.csv");

        UserCollection userCollection = new UserCollection();

        // Menú de opciones
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar Pokémon a la colección del usuario");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémon del usuario ordenados por Type1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Type1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");

            int choice = md.nextInt();
            md.nextLine(); // Limpiar buffer

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = md.nextLine();
                    userCollection.addPokemon(name, pokemonMap);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    name = md.nextLine();
                    userCollection.showPokemonData(name, pokemonMap);
                    break;
                case 3:
                    userCollection.showUserPokemonsSorted();
                    break;
                case 4:
                    csvLoader.showAllPokemonsByType(pokemonMap);
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = md.nextLine();
                    csvLoader.findPokemonByAbility(pokemonMap, ability);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}