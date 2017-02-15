package HW_14febrary;

/**
 * Created by Timbaev on 14.02.2017.
 * Main Application
 */
public abstract class Application {
    protected String[] args;

    public Application(String[] args){
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init();
    public abstract void start();
}
