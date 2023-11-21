package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import java.util.ArrayList;
import java.util.Arrays;

public class IceCreamApp2 {

    public static void main(String[] args) {

        PriceList priceList = new PriceList();
        Stock stock = new Stock();
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);

        ArrayList<Eatable> orders = new ArrayList<>();

        /*orders.add(iceCreamSeller.orderIceRocket());
        orders.add(iceCreamSeller.orderCone(Arrays.stream(Cone.Flavor.values())
                .filter(f -> f.equals(Cone.Flavor.BANANA) || f.equals(Cone.Flavor.CHOCOLATE))
                .toArray(Cone.Flavor[]::new)));*/
        System.out.println(stock.getMagni());
        orders.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES));
        orders.add(iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));

        for (int i = 0; i < orders.size(); i++) {
            if(stock.getMagni()>0)
                orders.get(i).eat();
        }
        System.out.println();
        System.out.println(iceCreamSeller.getProfit());
        System.out.println(stock.getMagni());
        stock.setMagni(stock.getMagni());
        stock.setMagni(stock.getMagni());


        System.out.println(stock.getMagni());
    }
}
