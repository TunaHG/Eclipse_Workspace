package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serv05")
public class ProductService05 implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public ProductVO sell() {
		System.out.println("May Sale percent is 30%");
		return dao.sell(0.3, 1);
	}
	
}
