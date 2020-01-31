package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serv12")
public class ProductService12 implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public ProductVO sell() {
		System.out.println("December Sale percent is 50%");
		return dao.sell(0.5, 0);
	}
	
}
