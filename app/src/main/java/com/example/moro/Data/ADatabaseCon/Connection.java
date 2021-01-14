package com.example.moro.Data.ADatabaseCon;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

import org.bson.BSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/***
 * @author Mikkel Johansen s175194
 */
public class Connection {
    DBCollection coll;
    private DB database;
    private static Connection connection;

    public Connection() throws UnknownHostException {
            MongoCredential credential = MongoCredential.createCredential("admin", "admin", "eCaayuCie4".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("95.179.180.78:27017"), Arrays.asList(credential));
            database = mongoClient.getDB("moro");

    }

    public static Connection getInstance() throws UnknownHostException {
        if(connection != null)
            return connection;
        return connection = new Connection();
    }

    public void insertCollection(String json, String collection){
        coll = database.getCollection(collection);
        DBObject bson = ( DBObject ) JSON.parse(json);
        coll.update(bson, bson, true, false);
    }

    public void findSpecific(String collection, String searchFilter, String searchFieldInput){

            BasicDBObject SearchQuery = new BasicDBObject();
            SearchQuery.put(searchFilter, searchFieldInput);
            coll = database.getCollection(collection);
            DBCursor cursor = coll.find(SearchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
    }

    public DBCursor findAll(String collection){
        final DBCursor c;
            coll = database.getCollection(collection);
            System.out.println(coll.count());
            //c = coll.find();
        return null;
    }
}
