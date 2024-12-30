package lk.esoft.pizza.connector;
import lk.esoft.pizza.service.ServiceFactory;
import lk.esoft.pizza.service.SuperService;
import lk.esoft.pizza.service.custom.*;

import java.rmi.Naming;

public class ProxyHandler {
    private static ProxyHandler ph;
    private final CallOperatorService callOperatorService;
    private final CustomerService customerService;
    private final CusOrderService cusOrderService;
    private final ChefService chefService;
    private final AdminService adminService;
    private final ReportService reportService;

    private ProxyHandler() throws Exception {
        ServiceFactory serviceProxy = (ServiceFactory) Naming.lookup("rmi://localhost:5050/PizzaServer");
        this.callOperatorService = (CallOperatorService) serviceProxy.getService(ServiceFactory.ServiceType.CALL_OPERATOR);
        this.customerService = (CustomerService) serviceProxy.getService(ServiceFactory.ServiceType.CUSTOMER);
        this.cusOrderService = (CusOrderService) serviceProxy.getService(ServiceFactory.ServiceType.CUS_ORDER);
        this.chefService = (ChefService) serviceProxy.getService(ServiceFactory.ServiceType.CHEF);
        this.adminService = (AdminService) serviceProxy.getService(ServiceFactory.ServiceType.ADMIN);
        this.reportService = (ReportService) serviceProxy.getService(ServiceFactory.ServiceType.REPORT);
    }
    public static ProxyHandler getInstance() throws Exception {
        if (ph == null) {
            ph = new ProxyHandler();
        }
        return ph;
    }
    public enum ProxyTypes {
        CALL_OPERATOR, CUSTOMER, CUS_ORDER, CHEF, ADMIN, REPORT
    }
    public SuperService getProxy(ProxyTypes types) {
        switch (types) {
            case CALL_OPERATOR:
                return callOperatorService;
            case CUSTOMER:
                return customerService;
            case CUS_ORDER:
                return cusOrderService;
            case CHEF:
                return chefService;
            case ADMIN:
                return adminService;
            case REPORT:
                return reportService;
            default:
                return null;
        }
    }

}
