package com.abhinav.dropwizard;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;


/**
 * @author abhinav.prakash
 * 
 */
public class HelloWorldConfiguration extends Configuration
{
    @NotEmpty
    @JsonProperty
    private String       template;

    @NotEmpty
    @JsonProperty
    private final String defaultName = "Stranger";

    public String getTemplate()
    {
        return template;
    }

    public String getDefaultName()
    {
        return defaultName;
    }

}
