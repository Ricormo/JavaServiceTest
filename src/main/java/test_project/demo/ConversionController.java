package test_project.demo;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversionController {

    @PostMapping(path="/convert/toXml", produces = MediaType.APPLICATION_XML_VALUE)
    public Object convertToXml(@RequestBody String request) throws JSONException {
        JSONObject json = new JSONObject(request);
        return XML.toString(json, "root");
    }

    @PostMapping(path="/convert/toJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object convertToJson(@RequestBody String request) {
        JSONObject jsonObject = XML.toJSONObject(request);
        return jsonObject.toString();
    }
}