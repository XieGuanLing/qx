package com.ws.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ws.advice.JsonResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 */
@Component
public class JsonModule extends SimpleModule {


    public JsonModule() {

        addSerializer(Page.class, new JsonSerializer<Page>() {
            @Override
            public void serialize(Page value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartObject();
                gen.writeNumberField("total", value.getTotalElements());
                gen.writeFieldName("rows");
                serializers.defaultSerializeValue(value.getContent(), gen);
                gen.writeEndObject();
            }
        });


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
