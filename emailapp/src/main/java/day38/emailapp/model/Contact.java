package day38.emailapp.model;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Contact {
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private String email;

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("name", name)
            .add("email", email)
            .build();
    }

    // public static List<Contact> createJsonFromString(String json) {
    //     List<Contact> conctList = new LinkedList<>();

    //     StringReader sR = new StringReader(json);
    //     JsonReader jR = Json.createReader(sR);

    // }

}
