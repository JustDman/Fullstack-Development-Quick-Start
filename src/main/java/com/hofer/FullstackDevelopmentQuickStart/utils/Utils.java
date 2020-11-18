package com.hofer.FullstackDevelopmentQuickStart.utils;

import org.springframework.stereotype.Service;

@Service
public class Utils {

    private Long i = 0L;

    public Long generateId() {
        i++;
        return i;
    }
}
