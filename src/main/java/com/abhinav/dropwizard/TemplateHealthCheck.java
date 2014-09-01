package com.abhinav.dropwizard;

import com.yammer.metrics.core.HealthCheck;


/**
 * @author abhinav.prakash
 * 
 */
public class TemplateHealthCheck extends HealthCheck
{
    private final String template;

    /**
     * @param name
     */
    protected TemplateHealthCheck(final String template)
    {
        super(template);
        this.template = template;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yammer.metrics.core.HealthCheck#check()
     */
    @Override
    protected Result check() throws Exception
    {
        String saying = String.format(template, "TEST");
        if (!saying.contains("THIS"))
        {
            return Result.healthy("template doesn't include the name");
        }
        return Result.healthy();
    }

}
