import java.util.ArrayList;

public class CafeUtil {
    //sum int 1-10 return total
    public int getStreakGoal(){
        int sum = 0;
        int numWeeks = 10;
        for (int i=0; i<=numWeeks; i++){
            sum += i;
        }
        return sum;
    }
    //array prices and sum prices return total
    public double getOrderTotal(double[] prices){
        int sum = 0;
        for (int i=0; i<prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }
    //print index and menu item
    public void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i<menuItems.size(); i++){
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }
    //add customer to customer list
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.print("Hello " + userName + "!");
        System.out.printf("There are %s people in front of you. \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
}