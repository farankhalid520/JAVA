
import java.util.*;

public class FCFS {
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter no of process: ");
        int x = obj.nextInt();
        if (x<=0) //Checks if no. of processes are negative
        {
            System.out.println("Error : No. of processes can't be negative ! Try Again");
            System.out.println("Enter number of processes: ");
            x = obj.nextInt();
        }
        int process[] = new int[x];
        int arrivalTime[] = new int[x];
        int burstTime[] = new int[x];
        int completeTime[] = new int[x];
        int turnaoundTime[] = new int[x];
        int waitingTime[] = new int[x];
        int temp;
        float AWT=0;

        for(int i = 0; i < x; i++)
        {
            System.out.println("Enter process number " + (i+1) + " Arrival Time: ");
            arrivalTime[i] = obj.nextInt(); //takes arrival time from user
            if(arrivalTime[i] <0) //checks if arrival time is negative
            {
                while (arrivalTime[i] < 0)
                {
                    System.out.println("Error : Arrival Time can't be negative ! Try Again");
                    System.out.println("Enter process number " + (i + 1) + " Arrival Time");
                    arrivalTime[i] = obj.nextInt();
                }
         }
            System.out.println("Enter process number " + (i+1) + " burst time: ");
            burstTime[i] = obj.nextInt(); //takes burst time from user
            if(burstTime[i] <0)  //checks if he burst time is negative
            {
                while (burstTime[i] < 0)
                {
                    System.out.println("Error : Burst Time can't be negative ! Try Again");
                    System.out.println("Enter process number " + (i + 1) + "Burst Time");
                    burstTime[i] = obj.nextInt();
                }
            }
            process[i] = (i+1); //increments process no.
        }


        for(int i = 0 ; i < x; i++) //traversing through processes 
        {
            for(int  j = 0;  j < x-(i+1) ; j++)
            {
                if( arrivalTime[j] > arrivalTime[j+1] )
                {
                    temp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j+1]; //swapping arrival time of j & j+1
                    arrivalTime[j+1] = temp;
                    temp = burstTime[j];
                    burstTime[j] = burstTime[j+1]; //swapping burst time of j & j+1
                    burstTime[j+1] = temp;
                    temp = process[j];
                    process[j] = process[j+1]; //swapping processes j & j+1
                    process[j+1] = temp;
                }
            }
        }


        for(int  i = 0 ; i < x; i++)
        {
            if( i == 0) //for the first process
            {
                completeTime[i] = arrivalTime[i] + burstTime[i]; //calculates completion time
            }
            else
            {
                if( arrivalTime[i] > completeTime[i-1]) //arrival time of process 1 is > completion time of process 0
                {
                    completeTime[i] = arrivalTime[i] + burstTime[i];
                }
                else
                    completeTime[i] = completeTime[i-1] + burstTime[i]; //if AT of process 1 is <= to process 0...add bursts in CT of process 0
            }
            turnaoundTime[i] = completeTime[i] - arrivalTime[i] ; //calculates turn around time
            waitingTime[i] = turnaoundTime[i] - burstTime[i] ;//calculates waiting time
            AWT += waitingTime[i] ;

        }

        System.out.println("\nProcess \t\t ArrivalTime \t\t BrustTime \t\t CompleteTime \t\t TurnAroundTime \t\t WaitingTime");
        for(int  i = 0 ; i< x;  i++)
        {
            System.out.println(process[i] + "  \t\t\t " + arrivalTime[i] + "\t\t\t" + burstTime[i] + "\t\t\t" + completeTime[i] + "\t\t\t" + turnaoundTime[i] + "\t\t\t\t"  + waitingTime[i] ) ;
        }
        System.out.println("\nAverage waiting time: "+ (AWT/x)); //calculates the Average waiting time

    }

}