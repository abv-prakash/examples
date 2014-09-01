package com.abhinav.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;


/**
 * @author abhinav.prakash
 * 
 */
public class HelloWorldService extends Service<HelloWorldConfiguration>
{

    public static void main(final String args[]) throws Exception
    {
        new HelloWorldService().run(args);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yammer.dropwizard.Service#initialize(com.yammer.dropwizard.config.Bootstrap)
     */
    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap)
    {
        bootstrap.setName("hello-world");

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yammer.dropwizard.Service#run(com.yammer.dropwizard.config.Configuration,
     * com.yammer.dropwizard.config.Environment)
     */
    @Override
    public void run(final HelloWorldConfiguration configuration, final Environment environment) throws Exception
    {
        String template = configuration.getTemplate();
        String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));

    }

}
