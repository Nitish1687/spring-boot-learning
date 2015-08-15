package com.nitish.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.nitish.model.Greeting;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class GreetingMessageRepository {

    private static final String GREETING = "greeting";

    public MongoDatabase getMongoDb() {
        MongoClient client = new MongoClient("localhost");
        return client.getDatabase("test");
    }

    public List<Greeting> getGreetingMessage() {
        MongoCursor<Document> iterator = getMongoDb().getCollection(GREETING).find().iterator();
        List<Greeting> greetings = new ArrayList<>();
        while(iterator.hasNext()) {
            Document next = iterator.next();
            greetings.add(new Greeting((String)next.get("name"),(Date) next.get("date")));
        }
        return greetings;
    }


    public void addGreetingMessageToMongoDb(List<Greeting> greetings) {
        ArrayList<Document> documents = new ArrayList<>();
        for (Greeting greeting : greetings) {
            documents.add(new Document("name", greeting.getName()).append("date", greeting.getDate()));
        }
        getMongoDb().getCollection(GREETING).insertMany(documents);
    }

    public static void main(String[] args) {
        GreetingMessageRepository greetingMessageRepository = new GreetingMessageRepository();
        MongoDatabase mongoDb = greetingMessageRepository.getMongoDb();
        MongoCollection<Document> greeting = mongoDb.getCollection(GREETING);
        greeting.drop();
        greeting.insertMany(asList(new Document("name", "Nitish").append("date", new Date()), new Document("name", "Shukla").append("date", new Date())));
    }

}

