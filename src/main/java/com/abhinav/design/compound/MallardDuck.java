package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class MallardDuck implements Quackable
{
    Observable observable;

    public MallardDuck()
    {
        observable = new Observable(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.Quackable#quack()
     */
    public void quack()
    {
        System.out.println("Quack");
        notifyObservers();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#registerObserver(com.abhinav.design.compound.Observer)
     */
    public void registerObserver(final Observer observer)
    {
        observable.registerObserver(observer);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#notifyObservers()
     */
    public void notifyObservers()
    {
        observable.notifyObservers();

    }

}
