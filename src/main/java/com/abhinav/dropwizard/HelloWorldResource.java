package com.abhinav.dropwizard;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;


/**
 * @author abhinav.prakash
 * 
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource
{
    private final String     template;
    private final String     defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(final String template, final String defaultName)
    {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();

    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") final Optional<String> name)
    {
        return new Saying(counter.incrementAndGet(), String.format(template, name.or(defaultName)));
    }
}
