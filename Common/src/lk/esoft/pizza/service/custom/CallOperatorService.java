package lk.esoft.pizza.service.custom;

import lk.esoft.pizza.dto.CallOperatorDTO;
import lk.esoft.pizza.service.SuperService;

public interface CallOperatorService extends SuperService {
    public CallOperatorDTO login(String username, String password) throws Exception;
    public String[] getAllPizzas() throws Exception;
}
