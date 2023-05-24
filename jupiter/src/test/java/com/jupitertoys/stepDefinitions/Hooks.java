package com.jupitertoys.stepDefinitions;

import com.jupitertoys.factory.Driverfactory;
import com.jupitertoys.factory.World;
import com.jupitertoys.util.PropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private World world;
    private Driverfactory driverfactory;

    public Hooks(World world){
        this.world = world;
     }

    @Before(order = 1)
    public void setUpDriver() throws InterruptedException{
        driverfactory = new Driverfactory();
        world.driver=( driverfactory.initDriver(PropertyReader.getBrowser()));
        world.driver.get(PropertyReader.getWebsiteUrl());
    }

    @After
    public void closeDriver(){
        PropertyReader.cleanUp();
        world.driver.quit();
    }
}
