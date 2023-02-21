package day38.emailapp.controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonToken;

import day38.emailapp.repositories.EmailRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

@Controller
@RequestMapping
public class EmailController {
    
    
    @Autowired
    private EmailRepository eRepo;
    

    @PostMapping(path="/sync")
    @ResponseBody
    public ResponseEntity<String> syncEmail(@RequestBody String payload) {
        
        System.out.println(payload); 
        try (JsonReader reader = Json.createReader(new StringReader(payload))) {
            JsonArray jsonArray = reader.readArray();
            System.out.println(jsonArray);
            eRepo.bulkInsert(jsonArray);
            
        } catch (JsonException e) {
            e.printStackTrace();
        }

        JsonObject test = Json.createObjectBuilder()
            .add("message", "sync success")
            .build();
        
        return ResponseEntity.ok().body(test.toString()
        );
    }
}
