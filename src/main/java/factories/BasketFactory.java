package factories;
import dao.BasketInterfaceDAO;
import dao.BasketQueryDAO;
import services.BasketServiceInterface;
import services.BasketServiceImplementation;

public class BasketFactory {

	public static BasketInterfaceDAO getBasketQueryDAO() {
		return new BasketQueryDAO();
	}
	public static BasketServiceInterface getBasketServiceIMplementation(BasketInterfaceDAO bi) {
		return new BasketServiceImplementation(bi);
	}
}
