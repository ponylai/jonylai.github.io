package org.spring.springboot.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BQ0196 on 2017/5/19.
 */

    public class DateJsonDeserializer extends JsonDeserializer<Date>
    {
        public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException,JsonProcessingException
        {
            try
            {
                return format.parse(jsonParser.getText());
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

