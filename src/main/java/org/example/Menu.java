package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class Menu {

    public static void menu() {

        MongoClient mongoClient = ConexionSingleton.getConexionBD();
        MongoDatabase mongoD = mongoClient.getDatabase("GameFreak");
        MongoCollection<Document> mongoC = mongoD.getCollection("Pokemons");
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("\n-- MENÚ CONSULTAS --");
            System.out.println("1. Pokémon altura >= 150 cm ordenados desc");
            System.out.println("2. Peso >= 80 kg y capture_rate < 50");
            System.out.println("3. Color red y habitat mountain");
            System.out.println("4. Growth_rate fast y generation-i");
            System.out.println("5. Flavor_text_es contiene 'cola'");
            System.out.println("6. Pokémon legendarios o míticos");
            System.out.println("7. Tipo bicho y volador");
            System.out.println("8. Color yellow, debilidad tierra y speed > 80");
            System.out.println("9. Habitat forest y tipo normal o veneno");
            System.out.println("10. Capture_rate >= 200 sin evolución siguiente");
            System.out.println("11. Con alguna habilidad oculta");
            System.out.println("12. Habilidad oculta que empiece por 'g'");
            System.out.println("13. Limitar ataque máximo a 100");
            System.out.println("14. Incrementar speed +5 a tipo dragon");
            System.out.println("15. Añadir modificadoAFechaDe a habilidad oculta");
            System.out.println("16. Añadir tipo Fairy a Pikachu");
            System.out.println("17. Eliminar última debilidad de tipo lucha");
            System.out.println("18. Eliminar next_evolution con num = 003");
            System.out.println("19. Añadir entrenador Ash Mostaza a Pikachu y Charizard");
            System.out.println("20. Eliminar campo entrenador");
            System.out.println("21. Eliminar Pokémon con altura > 200 cm");
            System.out.println("22. Eliminar primer Pokémon legendario");
            System.out.println("0. Salir");

            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> Consultas.consulta1(mongoC);
                case 2 -> Consultas.consulta2(mongoC);
                case 3 -> Consultas.consulta3(mongoC);
                case 4 -> Consultas.consulta4(mongoC);
                case 5 -> Consultas.consulta5(mongoC);
                case 6 -> Consultas.consulta6(mongoC);
                case 7 -> Consultas.consulta7(mongoC);
                case 8 -> Consultas.consulta8(mongoC);
                case 9 -> Consultas.consulta9(mongoC);
                case 10 -> Consultas.consulta10(mongoC);
                case 11 -> Consultas.consulta11(mongoC);
                case 12 -> Consultas.consulta12(mongoC);
                case 13 -> Consultas.consulta13(mongoC);
                case 14 -> Consultas.consulta14(mongoC);
                case 15 -> Consultas.consulta15(mongoC);
                case 16 -> Consultas.consulta16(mongoC);
                case 17 -> Consultas.consulta17(mongoC);
                case 18 -> Consultas.consulta18(mongoC);
                case 19 -> Consultas.consulta19(mongoC);
                case 20 -> Consultas.consulta20(mongoC);
                case 21 -> Consultas.consulta21(mongoC);
                case 22 -> Consultas.consulta22(mongoC);
                case 0 -> {
                    salir = true;
                    System.out.println("Saliendo del menú...");
                }
                default -> System.out.println("Opción no válida.");
            }

        } while (!salir);

        sc.close();
    }
}
