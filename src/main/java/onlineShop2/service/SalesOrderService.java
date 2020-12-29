package onlineShop2.service;

import onlineShop2.dao.ProductDao;
import onlineShop2.dao.SalesOrderDao;
import onlineShop2.entity.CartItem;
import onlineShop2.entity.Product;
import onlineShop2.entity.SalesOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderDao salesOrderDao;
    @Autowired
    private ProductDao productDao;

    public void addSalesOrder(SalesOrder salesOrder) {
        salesOrderDao.addSalesOrder(salesOrder);

        for(CartItem cartItem : salesOrder.getCart().getCartItem()){
            Product product = cartItem.getProduct();
            String unitStock = product.getUnitStock();
            int quantity = cartItem.getQuantity();
            int newStock = Integer.valueOf(unitStock) - quantity;
            product.setUnitStock(newStock + "");
            if(newStock > 0){
                productDao.updateProduct(product);
            } else {
                productDao.deleteProduct(product.getId());
            }
        }
    }

    public synchronized void updateStock(SalesOrder salesOrder){
        for(CartItem cartItem : salesOrder.getCart().getCartItem()){
            Product product = cartItem.getProduct();
            String unitStock = product.getUnitStock();
            int quantity = cartItem.getQuantity();
            int newStock = Integer.valueOf(unitStock) - quantity;
            product.setUnitStock(newStock + "");
            if(newStock > 0){
                productDao.updateProduct(product);
            } else {
                productDao.deleteProduct(product.getId());
            }
        }
    }
}

