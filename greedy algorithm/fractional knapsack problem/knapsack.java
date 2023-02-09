import java.util.ArrayList;
import java.util.*;

class KnapsackItem{
    private int index;
    private int value;
    private int weight;
    public double ratio;

    public KnapsackItem(int index , int value , int weight){

        this.index = index;
        this.value = value;
        this.weight = weight;

        ratio = (value*1.0) / weight; 
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }


    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }


    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    public double getRatio(){
        return ratio;
    }
    public void setRatio(double  ratio){
        this.ratio = ratio;
    }

    @Override

    public String toString(){
        return "index = "+index+"   value = "+value+"   weight = "+weight+"  ratio = "+ratio;
    }
}
class FractionalKnapsack{
    public static void knapsackSolution(ArrayList<KnapsackItem> items , int capacity){

        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override

            public int compare(KnapsackItem k1 , KnapsackItem k2){
                if (k2.getRatio() > k1.getRatio()) {
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };

        Collections.sort(items, comparator);

        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item : items) {
            if (usedCapacity+item.getWeight() <= capacity) {
                usedCapacity+=item.getWeight();
                System.out.println("takem : item "+item);
                totalValue+=item.getValue();
            }
            else{
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio()*usedWeight;
                System.out.println("taken : item index = "+item.getIndex()+"  value = "+item.getValue()+"  weight = "+usedWeight+"  ratio = "+item.getRatio());
                usedCapacity+=usedWeight;
                totalValue+=value;
            }
        }
        System.out.println("total value = "+totalValue);
    }
}
public class knapsack {
    public static void main(String[] args) {
        
        ArrayList<KnapsackItem> items = new ArrayList<KnapsackItem>();
        int [] values= {100,120,60};
        int weight[]={20,30,10};
        int capacity = 50;

        for (int i = 0; i < weight.length; i++) {
            items.add(new KnapsackItem(i+1,values[i], weight[i]));
        }

        FractionalKnapsack.knapsackSolution(items , capacity);

        // output 

        // takem : item index = 3   value = 60   weight = 10  ratio = 6.0
        // takem : item index = 1   value = 100   weight = 20  ratio = 5.0
        // taken : item index = 2  value = 120  weight = 20  ratio = 4.0
        // total value = 240.0
    }   
}
