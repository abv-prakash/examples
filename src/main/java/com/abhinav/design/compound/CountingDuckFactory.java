package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class CountingDuckFactory extends AbstractDuckFactory
{

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.AbstractDuckFactory#createMallardDuck()
     */
    @Override
    public Quackable createMallardDuck()
    {
        return new QuackCounter(new MallardDuck());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.AbstractDuckFactory#createRedHeadDuck()
     */
    @Override
    public Quackable createRedHeadDuck()
    {
        return new QuackCounter(new RedheadDuck());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinav.design.compound.AbstractDuckFactory#createRubberDuck()
     */
    @Override
    public Quackable createRubberDuck()
    {
        return new QuackCounter(new RubberDuck());
    }

}
