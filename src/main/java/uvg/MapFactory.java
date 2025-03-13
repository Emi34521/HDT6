package uvg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
public static Map<String, Pokemon> createMap(int option) {
        switch (option) {
            case 1: return new HashMap<>();
            case 2: return new TreeMap<>();
            case 3: return new LinkedHashMap<>();
            default: throw new IllegalArgumentException("Opción inválida");
        }
    }
}
