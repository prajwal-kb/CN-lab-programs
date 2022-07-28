import java.util.Scanner;

public class prg12leakyBucketAlgo {
    public static void main(String[] args) {
        int i;
        int a[] = new int [20];
        int rem = 0 , cap , rate , sent=0 , recv=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bucket capacity : ");
        cap = sc.nextInt();
        System.out.println("Enter the output rate of the bucket : ");
        rate = sc.nextInt();
        System.out.println("Enter the no of packet : ");
        int n = sc.nextInt();
        System.out.println("Enter the packet : ");
        for(i = 1 ;i <= n;i++)
            a[i] = sc.nextInt();
        System.out.println("Clock \t Packet Size \t Accept \t Sent \t Remaining");
        for(i = 1;  i <= n; i++){
            if(a[i] != 0){
                if(rem + a[i] > cap){
                    recv = -1;
                }
                else{
                    recv = a[i];
                    rem += a[i];
                }
            }
            else 
                recv = 0;
            if(rem != 0)    {
                if(rem < rate)  {
                    sent = rem;
                    rem = 0;
                }
                else    {
                    sent = rate;
                    rem -= rate;
                }
            }
            else 
                sent = 0;
            
            if(recv == -1)
                System.out.println(i+"\t\t"+a[i]+"\tdropped\t\t\t"+sent+"\t\t\t"+rem);
            else
                System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t\t"+sent+"\t\t"+rem);
        }
    }
}