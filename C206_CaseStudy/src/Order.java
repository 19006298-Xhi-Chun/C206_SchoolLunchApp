import java.util.ArrayList;
//done by LXC
public class Order {
    
    private String studentId;
    private String orderDate; 
    private String items;
    
    

 

    
    public Order(String studentId, String orderDate, String items) {
        this.studentId = studentId;
        this.orderDate = orderDate; 
        this.items = items;
        
    }

 

    public String getStudentId() {
        return studentId;
    }

 

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

 

    public String getOrderDate() {
        return orderDate;
    }

 

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

 

    public String getItems() {
        return items;
    }

 

    public void setItems(String items) {
        this.items = items;
    }
    
    public String toString() {
        return String.format("%-30s %-30s %-30s", studentId, orderDate, items);
    }

 

    public String getname() {
        return null;
    }
    public class price{
        public double ordered;
        public double cost;
    public void calcTotal() {
        double sum=ordered * cost;
        System.out.println("Total cost is" + sum);
    
    }
        public void display() {
            System.out.println("");
            calcTotal();
        }
    }
    
        }
//done

 