package com.abhinav.design.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author abhinav.prakash
 * 
 */
public class Flock implements Quackable
{

    List<Quackable>  flock            = new ArrayList<Quackable>();
    List<Observable> observedDuckList = new ArrayList<Observable>();

    public void add(final Quackable quacker)
    {
        flock.add(quacker);
        observedDuckList.add(new Observable(quacker));
    }

    public void quack()
    {
        Iterator<Quackable> iterator = flock.iterator();
        while (iterator.hasNext())
        {
            Quackable quackable = iterator.next();
            quackable.quack();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#registerObserver(com.abhinav.design.compound.Observer)
     */
    public void registerObserver(final Observer observer)
    {
        Iterator iterator = observedDuckList.iterator();
        while (iterator.hasNext())
        {
            Observable observedDuck = (Observable) iterator.next();
            observedDuck.registerObserver(observer);

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.QuackObservable#notifyObservers()
     */
    public void notifyObservers()
    {
        Iterator iterator = observedDuckList.iterator();
        while (iterator.hasNext())
        {
            Observable observedDuck = (Observable) iterator.next();
            observedDuck.notifyObservers();
        }

    }

}
