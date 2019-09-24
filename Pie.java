public class Pie {

    private String flavor;
    private int sweetnessLevel;
    private double price;
    private boolean eaten, cooked;

    public Pie(String f, int sL, double p){
        flavor = f;
        sweetnessLevel = sL;
        price = p;
    }
    public Pie(String f, int sL, double p, boolean e, boolean c){
        flavor = f;
        sweetnessLevel = sL;
        price = p;
        eaten = e;
        cooked = c;
    }
    public Pie(Pie p){
        flavor = p.flavor;
        sweetnessLevel = p.sweetnessLevel;
        price = p.price;
        eaten = p.eaten;
        cooked = p.cooked;
    }

    public void bakePie(){
        System.out.println("The " + this.flavor + " pie was baked!");
    }
    public void eatPie(){
        System.out.println("The " + this.flavor + " was eaten!");
    }
    public String getFlavor(){
        return flavor;
    }
    public double getPrice(){
        return price;
    }
}

class PieDemo{
    public static void main (String [] args){
        Pie pumpkinPie = new Pie("Pumpkin", 10, 5.99);
        Pie lemonMeringue = new Pie("Lemon Meringue", 5, 9.99);

        Pie Pecan = new Pie("Pecan", 2, 6.99, true, false);

        Pie copyPumpkin = new Pie(pumpkinPie);

        System.out.println(copyPumpkin.getFlavor());

        pumpkinPie.bakePie();
        System.out.println("The " + lemonMeringue.getFlavor() + " costs " + lemonMeringue.getPrice() + " dollars.");
    }
}
