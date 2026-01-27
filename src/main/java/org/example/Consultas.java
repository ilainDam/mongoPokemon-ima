package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;

public class Consultas {
    public static FindIterable<Document> consulta1(MongoCollection<Document> mongoC) {
        FindIterable<Document> pepe =  mongoC.find(Filters.gte("height", 150)).sort(Sorts.ascending("height"));
        for (Document doc : pepe) {
            System.out.println(doc.get("name"+" ; "+doc.get("height")));
        }
        return mongoC.find(Filters.gte("height", 150)).sort(Sorts.ascending("height"));
    }

    public static FindIterable<Document> consulta2(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(Filters.gte("weight", 80), Filters.lt("capture_rate", 50)));
    }

    public static FindIterable<Document> consulta3(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(Filters.eq("color", "red"), Filters.eq("habitat", "mountain")));
    }

    public static FindIterable<Document> consulta4(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.and(Filters.eq("growth_rate", "fast"), Filters.eq("generation", "generation-i")));
    }
    public static FindIterable<Document> consulta5(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.regex("flavor_text_es", "[cC][oO][lL][aA]"));
    }
    public static FindIterable<Document> consulta6(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.or(Filters.eq("is_legendary", true), Filters.eq("is_mythical", true)));
    }
    public static FindIterable<Document> consulta7(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.all("type", Arrays.asList("Bug","Flying")));
    }
    public static FindIterable<Document> consulta8(MongoCollection<Document> mongoC) {
        return mongoC.find(Filters.all("type", Arrays.asList("Bug","Flying")));
    }
}