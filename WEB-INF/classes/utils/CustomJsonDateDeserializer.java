package utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {  
	  @Override  
	    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {  
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	                String date = jp.getText();  
	                try {  
	                    return format.parse(date);  
	                } catch (ParseException e) {  
	                    throw new RuntimeException(e);  
	                }  
	    }  
}  
