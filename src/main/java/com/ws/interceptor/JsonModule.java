package com.ws.interceptor;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * User: Frank Tang <br/>
 * Date: 15/12/23<br/>                                               ·
 * Time: 下午4:21<br/>
 * Email: lovefree103@gmail.com<br/>
 */
@Component
public class JsonModule extends SimpleModule {


    public JsonModule() {

        addSerializer(Date.class, new JsonSerializer<Date>() {

            private final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

            @Override
            public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(df.format(value));
            }
        });
        addSerializer(JsonResponse.class, new JsonSerializer<JsonResponse>() {
            @Override
            public void serialize(JsonResponse value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartObject();
                gen.writeBooleanField("success", value.getSuccess());
                if (StringUtils.isNotBlank(value.getCode()))
                    gen.writeStringField("code", value.getCode());
                if (StringUtils.isNotBlank(value.getMsg()))
                    gen.writeStringField("msg", value.getMsg());
                if (value.getResultObject() != null) {
                    gen.writeFieldName("resultObject");
                    serializers.defaultSerializeValue(value.getResultObject(), gen);
                }
                if (value.getDetailErrors() != null) {
                    gen.writeFieldName("detailErrors");
                    serializers.defaultSerializeValue(value.getDetailErrors(), gen);
                }
                gen.writeEndObject();

            }
        });

        addDeserializer(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                try {
                    return new Date(Date.parse(p.getText()));
                } catch (Exception e) {
                    return null;
                }
            }
        });


    }


}
