package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class QuackCounter implements Quackable
{
    Quackable  duck;
    static int quackCounter;
    Observable observable;

    /**
     * 
     */
    public QuackCounter(final Quackable duck)
    {
        this.duck = duck;
        observable = new Observable(duck);
    }

    public void quack()
    {
        duck.quack();
        quackCounter++;
        notifyObservers();

    }

    public static int getQuackCount()
    {
        return quackCounter;
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
