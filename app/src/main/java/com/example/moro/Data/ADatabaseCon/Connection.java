package com.example.moro.Data.ADatabaseCon;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public class Connection {
    DBCollection coll;
    private final DB database;
    private static Connection connection;

    private Connection() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createCredential("admin", "admin", "eCaayuCie4".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("95.179.180.78:27017"), Arrays.asList(credential));
        database = mongoClient.getDB("moro");
    }

    public static Connection getInstance() throws UnknownHostException {
        if(connection != null)
            return connection;
        return connection = new Connection();
    }

    public void addToCollection(ArrayList<String> json, String collection){
        coll = database.getCollection(collection);
        for (String object : json) {
            DBObject bson = ( DBObject ) JSON.parse(object);
            coll.insert(bson);
        }
    }

    public void addToCollection(String json, String collection){
        coll = database.getCollection(collection);
        DBObject bson = ( DBObject ) JSON.parse(json);
        coll.insert(bson);
    }

    public void findAll(String collection){
        coll = database.getCollection(collection);
        coll.find();
    }

}
