package day38.emailapp.repositories;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

@Repository
public class EmailRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public void bulkInsert( JsonArray payload) {

        List<Document> docs = new LinkedList<>() ;

        // Testing
        // List<JsonObject> jObj = new LinkedList<>();

        for ( int i =0; i<payload.size(); i++){
            System.out.println(" >>>> insert success" + payload.getJsonObject(i));
            docs.add(Document.parse(payload.getJsonObject(i).toString()));
            // jObj.add(payload.getJsonObject(i));
            //  System.out.println(" >>>> JObject" + jObj);
            
        }
        // System.out.println(" >>>> JObject" + jObj);
        //  mongoTemplate.insert(jObj, "emails");
        //  System.out.println(" >>>> insert success" + jObj);

         mongoTemplate.insert(docs, "emails");
        // Collection<JsonValue> result = mongoTemplate.insertAll(payload, "email");
    }
    

}
