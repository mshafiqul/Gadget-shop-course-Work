public class Gadget
{private String model;
private double price;//pounds
private int weight;// grams
private String size;//size

public Gadget(String model,double price,int weight,String size)
{
    this.model = model;
    this.price = price;
    this.weight = weight;
    this.size = size;
    
}
public String getModel()
{
    return model;

}
public double getPrice()
{
    return price;
}
public int getWeight()

{return weight; 

}

public String getSize()
{return size;
    
}

public void display()
{System.out.println("Model:"+model);
 System.out.println("Price:£"+price);
 System.out.println("Weight:"+weight+"g");
 System.out.println("Size:"+size);
}



}