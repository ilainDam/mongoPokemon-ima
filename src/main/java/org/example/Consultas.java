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

    public static FindIterable<Document> consulta1(MongoCollection<Document> mongoC) {
        FindIterable<Document> pepe = mongoC.find(Filters.gte("height", 150))
                .sort(Sorts.ascending("height"));
        for (Document doc : pepe) {
            System.out.println(doc.get("name") + " ; " + doc.get("height"));
        }
        return pepe;
    }

    public static FindIterable<Document> consulta2(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.gte("weight", 80),
                Filters.lt("capture_rate", 50)
        ));
    }

    public static FindIterable<Document> consulta3(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.eq("color", "red"),
                Filters.eq("habitat", "mountain")
        ));
    }

    public static FindIterable<Document> consulta4(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.eq("growth_rate", "fast"),
                Filters.eq("generation", "generation-i")
        ));
    }

    // case-insensitive: contiene "cola"
    public static FindIterable<Document> consulta5(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.regex(
                "flavor_text_es",
                "cola",
                "i"
        ));
    }

    public static FindIterable<Document> consulta6(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.or(
                Filters.eq("is_legendary", true),
                Filters.eq("is_mythical", true)
        ));
    }

    public static FindIterable<Document> consulta7(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.all(
                "type",
                Arrays.asList("Bug", "Flying")
        ));
    }

    public static FindIterable<Document> consulta8(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.eq("color", "yellow"),
                Filters.eq("weaknesses", "ground"),
                Filters.gt("speed", 80)
        ));
    }

    public static FindIterable<Document> consulta9(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.eq("habitat", "forest"),
                Filters.in("type", "normal", "poison")
        ));
    }

    public static FindIterable<Document> consulta10(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.gte("capture_rate", 200),
                Filters.or(
                        Filters.exists("next_evolution", false),
                        Filters.size("next_evolution", 0)
                )
        ));
    }

    public static FindIterable<Document> consulta11(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.eq("abilities.is_hidden", true));
    }

    // empieza por "g", case-insensitive
    public static FindIterable<Document> consulta12(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(
                Filters.regex(
                        "abilities.name",
                        "^g",
                        "i"
                ),
                Filters.eq("abilities.is_hidden", true)
        ));
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
