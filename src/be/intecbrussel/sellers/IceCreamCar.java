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

        return prepareCone(balls);
    }

    private Cone prepareCone(Cone.Flavor[] balls){
        stock = new Stock();
        Cone cone;
        if (stock.getCones() > 0){
            cone = new Cone(balls);
            //for (int i = 0; i < balls.length; i++)
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
       return prepareIceRocket();
    }
    private IceRocket prepareIceRocket(){
        stock = new Stock();
        IceRocket iceRocket;
        if (stock.getIceRockets() > 0) {
            iceRocket = new IceRocket();
            profit += priceList.getRocketPrice() * 0.2;
            return iceRocket;
        }
        else {
            System.out.println("NO MORE ICECREAM");
            return null;
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        if (prepareMagnum(type).isPresent())
            return prepareMagnum(type).get();
        else {
            System.out.println("NO MORE ICECREAM");
            Magnum magnum = new Magnum();
            return magnum;
        }
    }
    private Optional<Magnum> prepareMagnum(Magnum.MagnumType type){
        stock = new Stock();
        Magnum magnum ;
        if (stock.getMagni() > 0) {
            magnum = new Magnum(type);
            profit += priceList.getMagnumPrice(type) * 0.01;
            return Optional.of(magnum);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
