package com.abhinav.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author abhinav.prakash
 * 
 */
public class JsonMapperTest
{

    public static class PctRequest
    {

    }

    public static void main(final String args[])
    {
        PctRequest request = new PctRequest();
        // request.setAppId("test-appid");
        // request.setGoalName("test-goal");
        // request.setGoalValue("test-value");
        // request.setRequestId("test-request-id");

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            System.out.println(mapper.writeValueAsString(request));
        }
        catch (JsonProcessingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
