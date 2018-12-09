package test_project.demo;

import org.json.XML;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversionController {

    @PostMapping(path="/convert", produces = MediaType.APPLICATION_XML_VALUE)
    public Object convert(@RequestBody String request) throws JSONException {
        JSONObject json = new JSONObject(request);
        return XML.toString(json);
    }
}