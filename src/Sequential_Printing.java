public class Sequential_Printing {
    volatile int count = 1;
    synchronized void Print_Num(){
        while(count<=75){
            if ((Thread.currentThread().getName()!="A"||count%3!=1)&&(Thread.currentThread().getName()!="B"||count%3!=0)&&(Thread.currentThread().getName()!="C"||count%3!=2)){
                try {
                    this.wait();
                    this.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"打印:"+count);
                count++;
            }

            }
            this.notifyAll();
        }
    }
    public static void main(String[] args){
        Sequential_Printing sequential_printing = new Sequential_Printing();
        new Thread(sequential_printing::Print_Num,"A").start();
        new Thread(sequential_printing::Print_Num,"B").start();
        new Thread(sequential_printing::Print_Num,"C").start();
    }
}
