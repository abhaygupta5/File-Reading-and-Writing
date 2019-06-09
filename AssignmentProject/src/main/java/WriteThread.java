import java.util.Date;

public class WriteThread extends Thread{
    private MyFileHandler typeOfFile;
    private int counter;

    public WriteThread(MyFileHandler typeOfFile, int counter){
        this.typeOfFile = typeOfFile;
        this.counter = counter;
    }
    public void run(){

            if (counter == 0) {
                for (int index = 0; index < 100; index++) {
                    Employee employee = MyController.myCollection.get(index);
                    try {
                        typeOfFile.write(employee);
                    }catch (Exception e){

                    }
                }
            } else if (counter == 1) {
                for (int index = 100; index < 200; index++) {
                    Employee employee = MyController.myCollection.get(index);
                    try {
                        typeOfFile.write(employee);
                    }catch (Exception e){

                    }
                }
            } else {
                for (int index = 200; index < 300; index++) {
                    Employee employee = MyController.myCollection.get(index);
                    try {
                        typeOfFile.write(employee);
                    }catch (Exception e){

                    }
                }
            }

    }

}
