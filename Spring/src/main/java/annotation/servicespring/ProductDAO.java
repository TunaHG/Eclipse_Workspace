package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	ProductVO vo;
	
	public ProductVO sell(double sale, int coupon) {
		vo.setSale(sale);
		vo.setCoupon(coupon);
		
		return vo;
	}
}
