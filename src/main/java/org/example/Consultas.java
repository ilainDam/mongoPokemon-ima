package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.time.LocalDate;
import java.util.Arrays;

public class Consultas {

    public static void printear(FindIterable<Document> docs) {
        for (Document doc : docs) {
            System.out.println(doc.toJson());
        }
    }

    public static void consulta1(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.gte("height", 150))
                        .sort(Sorts.ascending("height"))
        );
    }

    public static void consulta2(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.gte("weight", 80),
                        Filters.lt("capture_rate", 50)
                ))
        );
    }

    public static void consulta3(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.eq("color", "red"),
                        Filters.eq("habitat", "mountain")
                ))
        );
    }

    public static void consulta4(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.eq("growth_rate", "fast"),
                        Filters.eq("generation", "generation-i")
                ))
        );
    }

    public static void consulta5(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.regex("flavor_text_es", "cola", "i"))
        );
    }

    public static void consulta6(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.or(
                        Filters.eq("is_legendary", true),
                        Filters.eq("is_mythical", true)
                ))
        );
    }

    public static void consulta7(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.all("type", Arrays.asList("Bug", "Flying")))
        );
    }

    public static void consulta8(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.eq("color", "yellow"),
                        Filters.eq("weaknesses", "ground"),
                        Filters.gt("speed", 80)
                ))
        );
    }

    public static void consulta9(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.eq("habitat", "forest"),
                        Filters.in("type", "normal", "poison")
                ))
        );
    }

    public static void consulta10(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.gte("capture_rate", 200),
                        Filters.or(
                                Filters.exists("next_evolution", false),
                                Filters.size("next_evolution", 0)
                        )
                ))
        );
    }

    public static void consulta11(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.eq("abilities.is_hidden", true))
        );
    }

    public static void consulta12(MongoCollection<Document> mongoC) {
        printear(
                mongoC.find(Filters.and(
                        Filters.regex("abilities.name", "^g", "i"),
                        Filters.eq("abilities.is_hidden", true)
                ))
        );
    }

    public static void consulta13(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.gt("attack", 100),
                Updates.set("attack", 100)
        );
    }

    public static void consulta14(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.eq("type", "dragon"),
                Updates.inc("speed", 5)
        );
    }

    public static void consulta15(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.eq("abilities.is_hidden", true),
                Updates.set("modificadoAFechaDe", LocalDate.now().toString())
        );
    }

    public static void consulta16(MongoCollection<Document> mongoC) {
        mongoC.updateOne(
                Filters.eq("name", "Pikachu"),
                Updates.addToSet("type", "Fairy")
        );
    }

    public static void consulta17(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.eq("type", "fighting"),
                Updates.popLast("weaknesses")
        );
    }

    public static void consulta18(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.exists("next_evolution"),
                Updates.pull("next_evolution", new Document("num", "003"))
        );
    }

    public static void consulta19(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.in("name", "Pikachu", "Charizard"),
                Updates.set("entrenador", "Ash Mostaza")
        );
    }

    public static void consulta20(MongoCollection<Document> mongoC) {
        mongoC.updateMany(
                Filters.exists("entrenador"),
                Updates.unset("entrenador")
        );
    }

    public static void consulta21(MongoCollection<Document> mongoC) {
        mongoC.deleteMany(
                Filters.gt("height", 200)
        );
    }

    public static void consulta22(MongoCollection<Document> mongoC) {
        mongoC.deleteOne(
                Filters.eq("is_legendary", true)
        );
    }
}
