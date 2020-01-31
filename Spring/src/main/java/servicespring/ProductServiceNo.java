package servicespring;

public class ProductServiceNo implements ProductService {
	ProductDAO dao;
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ProductVO sell() {
		System.out.println("Another Month Sale percent is 0%");
		return dao.sell(0.0, 5);
	}
	
}
