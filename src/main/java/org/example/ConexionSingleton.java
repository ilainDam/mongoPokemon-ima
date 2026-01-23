package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.sql.SQLException;

public class ConexionSingleton {

    private static ConexionSingleton instance;
    private static MongoClient mongoClient;
    private final String url= "mongodb+srv://jacoboperdon:123456aed@cluster0.2v51nr8.mongodb.net/?appName=Cluster0";

    private ConexionSingleton() throws SQLException {
        try {
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(url))
                    .serverApi(serverApi)
                    .build();
            mongoClient = MongoClients.create(settings);

        }catch (Exception e){

        }
    }

    public static MongoClient getConexionBD(){
        try{
            if (instance == null){
                instance = new ConexionSingleton();
            }
        }catch (Exception e){

        }
        return mongoClient;
    }
}



