package com.wgdesign.shared.infrastructure.config;

public class ParameterNotExists extends Throwable {
    public ParameterNotExists(String key) {
        super(String.format("The parameter <%s> does not exist in the environment file", key));
    }
}
