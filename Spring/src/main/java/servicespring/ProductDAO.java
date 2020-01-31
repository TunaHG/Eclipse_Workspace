package servicespring;

public class ProductDAO {
	ProductVO vo;
	
	public void setVo(ProductVO vo) {
		this.vo = vo;
	}
	
	public ProductVO sell(double sale, int coupon) {
		vo.setSale(sale);
		vo.setCoupon(coupon);
		
		return vo;
	}
}
