package uvg;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CSVReader lector = CSVReader.getInstance();
        List<String[]> datos = lector.leerCSV("Pokemones.csv");
        Scanner md = new Scanner(System.in);
        
        System.out.println("Seleccione el tipo de Map a usar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        int option = md.nextInt();
        md.nextLine();
        
        Map<String, Pokemon> pokemonMap = MapFactory.createMap(option);
        
        for (String[] fila : datos) {
            if (fila.length >= 3) {
                Pokemon pokemon = new Pokemon(fila[0], fila[1], fila[2]);
                pokemonMap.put(fila[0], pokemon);
            }
        }
        
        Collection<Pokemon> userCollection = new HashSet<>();
        
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1) Agregar un Pokémon a la colección");
            System.out.println("2) Mostrar datos de un Pokémon");
            System.out.println("3) Mostrar colección ordenada por tipo");
            System.out.println("4) Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5) Mostrar Pokémon por habilidad");
            System.out.println("6) Salir");
            int choice = md.nextInt();
            md.nextLine();
            
            if (choice == 6) break;
            
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String name = md.nextLine();
                    if (pokemonMap.containsKey(name)) {
                        if (userCollection.stream().anyMatch(p -> p.getName().equals(name))) {
                            System.out.println("Ese Pokémon ya está en la colección.");
                        } else {
                            userCollection.add(pokemonMap.get(name));
                            System.out.println("Pokémon agregado con éxito.");
                        }
                    } else {
                        System.out.println("Error: Pokémon no encontrado en los datos leídos.");
                    }
                    break;
                
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    name = md.nextLine();
                    Pokemon pokemon = pokemonMap.get(name);
                    if (pokemon != null) {
                        System.out.println(pokemon);
                    } else {
                        System.out.println("Error: Pokémon no encontrado.");
                    }
                    break;
                
                case 3:
                    userCollection.stream()
                            .sorted(Comparator.comparing(Pokemon::getType1))
                            .forEach(System.out::println);
                    break;
                
                case 4:
                    pokemonMap.values().stream()
                            .sorted(Comparator.comparing(Pokemon::getType1))
                            .forEach(System.out::println);
                    break;
                
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = md.nextLine();
                    pokemonMap.values().stream()
                            .filter(p -> p.getAbility().equalsIgnoreCase(ability))
                            .forEach(System.out::println);
                    break;
                
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        md.close();
    }
        

    }