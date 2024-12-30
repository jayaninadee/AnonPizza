package lk.esoft.pizza.service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceType {
        CALL_OPERATOR, CUSTOMER, CUS_ORDER, CHEF, ADMIN, REPORT
    }
    public SuperService getService(ServiceType types)throws Exception;
}
