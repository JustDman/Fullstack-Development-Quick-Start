package com.hofer.FullstackDevelopmentQuickStart.utils;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
