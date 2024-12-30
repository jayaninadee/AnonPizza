package lk.esoft.pizza.service.custom;

import lk.esoft.pizza.dto.AdminDTO;
import lk.esoft.pizza.service.SuperService;

public interface AdminService extends SuperService {
      public AdminDTO login(String username, String password) throws Exception;
}
