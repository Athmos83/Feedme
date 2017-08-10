package com.feedme.feedme.common.repository;

import java.util.UUID;

public class IdGenerator {

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
