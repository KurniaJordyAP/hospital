package id.co.indivara.miniproject.hospital.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapperConvertion {
    public static <T> List<T> getAllData(String json, Class<T> elementClass) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        return objectMapper.readValue(json, listType);
    }

    public static <T> T getData(String json, Class<T> tClass) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, tClass);
    }

    public static <T> String toJson(T object) throws JsonProcessingException{
        return new ObjectMapper().writeValueAsString(object);
    }
}
