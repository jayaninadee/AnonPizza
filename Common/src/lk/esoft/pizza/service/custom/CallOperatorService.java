package lk.esoft.pizza.service.custom;

import lk.esoft.pizza.dto.CallOperatorDTO;

public interface CallOperatoService {
    public CallOperatorDTO login(String username, String password) throws Exception;
    public String[] getAllPizzas() throws Exception;
}
