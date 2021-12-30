package fr.lernejo.navy_battle;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsonFormat {
    final String id;
    final String url;
    final String message;
    public JsonFormat(String id,String url,String m){
        this.id = UUID.randomUUID().toString();
        this.url = url;
        this.message = m;
    }
    public String ToString(){
        Map<String,String> returnObject = new HashMap<>();
        returnObject.put("id",this.id);
        returnObject.put("url",String.valueOf(this.url));
        returnObject.put("message",this.message);
        return "";
    }
}
