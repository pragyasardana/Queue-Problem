import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class mainClass {
	public static Queue q[];
	public static int r[];
	public static int ptime[];
	public static boolean checkFlag; 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		checkFlag=true;
		r=new int[2];
		q = new Queue[2];
		ptime = new int[2];
		q[0] = new Queue();
		q[1] = new Queue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out
				.print("enter the maximum process time of first class passenger(in minute(s)): ");
		ptime[1] = Integer.parseInt(br.readLine());
		System.out
				.print("enter the maximum process time of coach passenger(in minute(s)): ");
		ptime[0] = Integer.parseInt(br.readLine());
		System.out
				.print("enter the average arrival rate of first class passenger(persons per minute): ");
		r[1] = Integer.parseInt(br.readLine());
		System.out
				.print("enter the average arrival rate of coach passenger(persons per minute): ");
		r[0] = Integer.parseInt(br.readLine());
		System.out.print("enter the time of execution: ");
		long totalTime = Integer.parseInt(br.readLine());
		serviceStation c1, c2, c3, f1, f2;
		passengerArrival cq, fq;
		c1 = new serviceStation(0);
		c2 = new serviceStation(0);
		c3 = new serviceStation(0);
		f1 = new serviceStation(1);
		f2 = new serviceStation(1);
		cq = new passengerArrival(0);
		fq = new passengerArrival(1);
		System.out.println("wait "+totalTime+" minutes");
		c1.start();
		c2.start();
		c3.start();
		f1.start();
		f2.start();
		cq.start();
		fq.start();
		Thread.sleep(totalTime*60*1000);
		checkFlag=false;
		System.out.println("Time Up");
		c1.join();
		c2.join();
		c3.join();
		f1.join();
		f2.join();
		cq.join();
		fq.join();
		long total_time=c1.totalTime+c2.totalTime+c3.totalTime+f1.totalTime+f2.totalTime;
		int countc=c1.count+c2.count+c3.count+f1.countc+f2.countc;
		int countf=f1.count+f2.count;
		int total_count=countc+countf;
		int max=Math.max(c1.maxTime, Math.max(c2.maxTime, Math.max(c3.maxTime, Math.max(f1.maxTime,f2.maxTime))));
		System.out.println("average service time "+ (total_time/(total_count)));
		System.out.println("maximum service time "+ max);
		System.out.println("number served by coach "+countc);
		System.out.println("number served by first "+countf);
		System.out.println("maximum coach queue length "+ cq.maxlength);
		System.out.println("maximum first queue length "+ fq.maxlength);
		
	}
}
