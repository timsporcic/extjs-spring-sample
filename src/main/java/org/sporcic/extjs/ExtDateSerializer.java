package com.codezombie.extjs;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A custom date serializer for Jackson JSON which will serialize a date in the
 * standard ISO format, like 2010-07-01T15:30:00
 */
public class ExtDateSerializer extends JsonSerializer<Date> {

    // the date format to use
    private final static String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        DateFormat formatter = new SimpleDateFormat(FORMAT);
        String formattedDate = formatter.format(value);

        gen.writeString(formattedDate);
    }
}
