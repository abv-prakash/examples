package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class GooseAdapter implements Quackable
{
    private final Goose goose;

    public GooseAdapter(final Goose goose)
    {
        this.goose = goose;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.Quackable#quack()
     */
    public void quack()
    {
        goose.honk();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#registerObserver(com.abhinav.design.compound.Observer)
     */
    public void registerObserver(final Observer observer)
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#notifyObservers()
     */
    public void notifyObservers()
    {
        // TODO Auto-generated method stub

    }

}
