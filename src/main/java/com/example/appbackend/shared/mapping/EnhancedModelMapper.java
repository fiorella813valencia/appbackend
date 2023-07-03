package com.example.appbackend.shared.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
        super();
    }


    //la lista que se envia se la envia como objeto
    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass){
        return sourceList.stream().map(item -> this.map(item, targetClass)).collect(Collectors.toList());
    }
}
