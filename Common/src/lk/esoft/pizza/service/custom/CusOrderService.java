package lk.esoft.pizza.service.custom;

import lk.esoft.pizza.dto.CusOrderDTO;
import lk.esoft.pizza.service.SuperService;

import java.util.ArrayList;

public interface CusOrderService extends SuperService {
    public boolean addOrder(CusOrderDTO cusOrderDTO) throws Exception;
    public ArrayList<CusOrderDTO> getQueue() throws Exception;
    public boolean startOrder(CusOrderDTO cusOrderDTO) throws Exception;
    public boolean finishOrder(CusOrderDTO cusOrderDTO) throws Exception;
}
