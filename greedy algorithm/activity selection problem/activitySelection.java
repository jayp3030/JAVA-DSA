import java.util.*;

class Activity{

    String name;
    int startTime;
    int finishTime;

    public Activity(String nameValue , int startTime , int finishTime){
        this.name = nameValue;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStartTme(){
        return startTime;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }

    public int getFinishtTme(){
        return finishTime;
    }

    public void finishTime(int finishTime){
        this.finishTime = finishTime;
    }

    @Override

    public String toString(){
        return "Activity : "+name+"   Start time = "+startTime+"   finish time = "+finishTime;
    }
}

class ASP{
    static void actSelection(ArrayList<Activity> activityList){

        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {

            @Override

            public int compare(Activity a1 , Activity a2){
                return a1.finishTime - a2.finishTime;
            }
        };

        Collections.sort(activityList, finishTimeComparator);

        Activity prevActivity = activityList.get(0);
        System.out.println("Shcedule to follow for optimal solution : \n"+prevActivity);

        for (int i = 1; i < activityList.size(); i++) {
            
            Activity activity = activityList.get(i);

            if (activity.getStartTme() >= prevActivity.getFinishtTme()) {
                
                System.out.println(activity);
                prevActivity = activity;
            }
        }
    }
}
public class activitySelection {
    public static void main(String[] args) {
        
        ArrayList<Activity> activityList = new ArrayList<Activity>();

        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        ASP.actSelection(activityList);

        // output:

        // Shcedule to follow for optimal solution : 

        // Activity : A3   Start time = 1   finish time = 2
        // Activity : A2   Start time = 3   finish time = 4
        // Activity : A5   Start time = 5   finish time = 7
        // Activity : A6   Start time = 8   finish time = 9
    }
}
