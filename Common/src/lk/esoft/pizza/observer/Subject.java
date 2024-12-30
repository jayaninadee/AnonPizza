package lk.esoft.pizza.observer;

import java.rmi.Remote;

public interface Subject extends Remote {
    public void register(Observer ob)throws Exception;
    public void unregister(Observer ob)throws Exception;
    public void notifyAllObservers(String message)throws Exception;
}
