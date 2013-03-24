package com.abhinav.design.compound;

/**
 * @author abhinav.prakash
 * 
 */
public class DuckSimulator
{

    DuckSimulator()
    {

    }

    public void simulate(final AbstractDuckFactory duckFactory)
    {

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable rubberheadDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberheadDuck);
        simulate(gooseDuck);

        System.out.println("total quacks : " + QuackCounter.getQuackCount());

    }

    public void simulate(final Quackable duck)
    {
        duck.quack();
    }

    public static void main(final String arg[])
    {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        duckSimulator.simulate(duckFactory);

    }

}
