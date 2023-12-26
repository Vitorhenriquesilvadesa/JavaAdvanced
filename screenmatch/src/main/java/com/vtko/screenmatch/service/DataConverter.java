package com.vtko.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements DataConverterI {
    private ObjectMapper mapper;

    public DataConverter(){
        this.mapper = new ObjectMapper();
    }

    @Override
    public <T> T fromJSON(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
