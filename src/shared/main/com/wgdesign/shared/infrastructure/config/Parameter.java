package com.wgdesign.shared.infrastructure.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

@Service
public class Parameter {
    private final Dotenv dotenv;

    public Parameter(Dotenv dotenv) {

        this.dotenv = dotenv;
    }

    public String get(String key) throws ParameterNotExists {
        String value = dotenv.get(key);

        if (null == value) {
            throw new ParameterNotExists(key);
        }

        return value;
    }

    public Integer getInt(String key) throws ParameterNotExists {
        String value = get(key);

        return Integer.parseInt(value);
    }
}
