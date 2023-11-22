package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Optional;
import java.util.stream.Collectors;

public class IceCreamCar implements IceCreamSeller{

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock){
        this.priceList = priceList;
        this.stock = stock;
    }


    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        if (prepareCone(balls) != null) {
            profit += priceList.getBallPrice() * 0.25;
            return prepareCone(balls);
        }
        else
            return null;
    }

    private Cone prepareCone(Cone.Flavor[] balls){
        Stock stock = this.stock;
        Cone cone;
        if (stock.getCones() > 0 || stock.getBalls() > 0){
            cone = new Cone(balls);
            for (int i = 0; i < balls.length; i++)
                profit += priceList.getBallPrice() * 0.25;
            return cone;
        }
        else {
            System.out.println("NO MORE ICECREAM");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {
        if (prepareIceRocket() != null) {
            profit += priceList.getRocketPrice() * 0.2;
            return prepareIceRocket();
        }
        else
            return null;
    }
    private IceRocket prepareIceRocket(){
        Stock stock = this.stock;
        IceRocket iceRocket ;
        if (stock.getIceRockets() > 0) {
            iceRocket = new IceRocket();
            return iceRocket;
        }
        else {
            System.out.println("NO MORE ICECREAM");
            return null;
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {

        if (prepareMagnum(type) != null) {
            profit += priceList.getMagnumPrice(type) * 0.01;
            return prepareMagnum(type);
        }
        else
            return null;
    }
    private Magnum prepareMagnum(Magnum.MagnumType type){
        Stock stock = this.stock;
        Magnum magnum ;
        if (stock.getMagni() > 0) {
            magnum = new Magnum(type);
            return magnum;
        }
        else {
            System.out.println("NO MORE ICECREAM");
            return null;
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
