package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class Quackologist implements Observer
{

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.Observer#update(com.abhinav.design.compound.QuackObservable)
     */
    public void update(final QuackObservable duck)
    {
        System.out.println("Quackologist : The observable " + duck + " just quacked");
    }

}
