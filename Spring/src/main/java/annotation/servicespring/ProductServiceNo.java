package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servNo")
public class ProductServiceNo implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public ProductVO sell() {
		System.out.println("Another Month Sale percent is 0%");
		return dao.sell(0.0, 5);
	}
	
}
