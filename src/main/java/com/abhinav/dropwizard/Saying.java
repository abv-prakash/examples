package com.abhinav.dropwizard;

/**
 * @author abhinav.prakash : Representation class for { "id" : 1, "content" : "hello , stranger!" }
 */
public class Saying
{
    private final long   id;
    private final String content;

    public Saying(final long id, final String content)
    {
        this.id = id;
        this.content = content;
    }

    public long getId()
    {
        return id;
    }

    public String getContent()
    {
        return content;
    }

}
