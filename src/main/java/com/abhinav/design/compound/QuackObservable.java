package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public interface QuackObservable
{
    public void registerObserver(Observer observer);

    public void notifyObservers();

}
