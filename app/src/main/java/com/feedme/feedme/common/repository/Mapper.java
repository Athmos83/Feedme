package com.feedme.feedme.common.repository;

import java.util.List;

public interface Mapper <T,Y> {

    T serialize(Y object);
    List<T> serialize(List<Y> objects);

    Y deserialize(T object);
    List<Y> deserialize(List<T> objects);
}