import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCollection{
    private static AtomicInteger writeCounter;
    private static AtomicInteger readCounter;
    private static List<Employee> employeeList;

    public MyCollection(){
        writeCounter = new AtomicInteger(0);
        readCounter = new AtomicInteger(0);
        employeeList = new Vector<>();
    }

    public static synchronized void add(Employee employee){
        employeeList.add(employee);
        writeCounter.getAndIncrement();

    }

    public static Employee get(int index){
        readCounter.getAndIncrement();
        if(index>=300 )    return null;
        Employee employee = employeeList.get(index);
        return employee;
    }

    public int getWriteCounter(){
        return writeCounter.get();
    }

    public int getReadCounter(){
        return readCounter.get();
    }

}
