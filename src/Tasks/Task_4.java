package Tasks;

public class Task_4 extends Thread{
    @Override
    public void run() {
        System.out.println(getName());
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Task_4 t = new Task_4();
            t.start();
        }
    }
}

//4. Напишите программу, которая создает 10 потоков
// и каждый поток выводит на экран свой номер.
