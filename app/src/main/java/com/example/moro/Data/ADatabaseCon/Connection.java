package com.example.moro.Data.ADatabaseCon;

import com.google.firebase.firestore.FirebaseFirestore;
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

public class Connection {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void Write(){
        db.collection("events");
    }
}
