public class MP3 extends Gadget
{
private int availableMemory;


public MP3(String model,double price,int weight,String size,int availableMemory)
{ super(model,price,weight,size);
    
this.availableMemory=availableMemory;
}
public int getAvailableMemory()
{return availableMemory;

}
public void downloadMusic(int memory){
if(availableMemory>=memory){
    availableMemory-=memory;
    System.out.println("Downloaded"+memory+"MB of music");
}
else{
System.out.println("Insufficint available memory to download music.");
}
}

public void deletMusic(int memory){
    availableMemory+=memory;
    System.out.println("Deleted"+memory+"MB of music.");
}
@Override
public void display(){
    super.display();
    System.out.println("Available memory:"+availableMemory+"MB");
}
    
    }
    