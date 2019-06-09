import java.io.File;

public class MyController {
    public static MyCollection myCollection;
    public static void main(String[] args) {
        myCollection = new MyCollection();
        MyFileHandler csvFileHandler= new CSVFileHandler();
        MyFileHandler xmlFileHandler = new XMLFileHandler(new File("employee.xml").getAbsolutePath());
        MyFileHandler jsonFileHandler = new JsonFileHandler();

        Thread csv = new Thread(new ReadThread(csvFileHandler));
        Thread xml = new Thread(new ReadThread(xmlFileHandler));
        Thread json = new Thread(new ReadThread(jsonFileHandler));

        csv.start();
        xml.start();
        json.start();


        try {
            csv.join();
            xml.join();
            json.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        csv = new Thread(new WriteThread(csvFileHandler, 0));
        xml = new Thread(new WriteThread(xmlFileHandler, 1));
        json = new Thread(new WriteThread(jsonFileHandler, 2));

        csv.start();
        xml.start();
        json.start();

        try{
            csv.join();
            xml.join();
            json.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

// need the join here, otherwise files won't be complete all the time. Main thread will get killed
    }
}
