package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import java.util.ArrayList;
import java.util.Arrays;

public class IceCreamApp2 {

    public static void main(String[] args) {

        PriceList priceList = new PriceList();
        Stock stock = new Stock();
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);
        Eatable iceRocket = new IceRocket();
        Eatable magnum = new Magnum();
        Eatable cone = new Cone();

        ArrayList<Eatable> orders = new ArrayList<>();

        orders.add(iceCreamSeller.orderIceRocket());
        checkStock(stock,iceRocket);
        orders.add(iceCreamSeller.orderIceRocket());
        checkStock(stock,iceRocket);
        orders.add(iceCreamSeller.orderIceRocket());
        checkStock(stock,iceRocket);
        orders.add(iceCreamSeller.orderCone(Arrays.stream(Cone.Flavor.values())
                .filter(f -> f.equals(Cone.Flavor.BANANA) || f.equals(Cone.Flavor.CHOCOLATE))
                .toArray(Cone.Flavor[]::new)));
        checkStock(stock,cone);
        orders.add(iceCreamSeller.orderCone(Arrays.stream(Cone.Flavor.values())
                .filter(f -> f.equals(Cone.Flavor.CHOCOLATE) || f.equals(Cone.Flavor.VANILLA))
                .toArray(Cone.Flavor[]::new)));
        checkStock(stock,cone);
        orders.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES));
        checkStock(stock,magnum);
        orders.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));
        checkStock(stock,magnum);

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i) != null)
                orders.get(i).eat();
        }

//
       System.out.println(iceCreamSeller.getProfit());
//

    }

    public static void checkStock(Stock stock, Eatable eatable){
        if (eatable instanceof IceRocket)
            stock.setIceRockets(stock.getIceRockets()-1);
        if (eatable instanceof Magnum)
            stock.setMagni(stock.getMagni()-1);
        if (eatable instanceof Cone) {
            stock.setCones(stock.getCones()-1);
            stock.setBalls(stock.getBalls()-(Cone.Flavor.values().length));
        }

    }
}
