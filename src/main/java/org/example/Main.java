package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = ConexionSingleton.getConexionBD();
        MongoDatabase mongoD = mongoClient.getDatabase("GameFreak");
        MongoCollection<Document> mongoC = mongoD.getCollection("Pokemons");
        mongoC.find().forEach(System.out::println);
    }
}
