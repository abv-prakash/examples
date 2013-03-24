package com.abhinav.design.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author abhinav.prakash
 * 
 */
public class Observable implements QuackObservable
{
    List<Observer>  observerList = new ArrayList<Observer>();
    QuackObservable duck;

    public Observable(final QuackObservable duck)
    {
        this.duck = duck;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#registerObserver(java.util.Observer)
     */
    public void registerObserver(final Observer observer)
    {
        observerList.add(observer);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#notifyObservers()
     */
    public void notifyObservers()
    {
        Iterator<Observer> iterator = observerList.iterator();
        while (iterator.hasNext())
        {
            Observer observer = iterator.next();
            observer.update(duck);
        }

    }
}
