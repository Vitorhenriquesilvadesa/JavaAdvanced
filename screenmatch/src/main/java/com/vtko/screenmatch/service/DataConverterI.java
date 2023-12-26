package com.vtko.screenmatch.service;

public interface DataConverterI  {

    public <T> T fromJSON(String json, Class<T> clazz);
}
