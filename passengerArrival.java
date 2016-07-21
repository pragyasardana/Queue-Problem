import java.util.Arrays;
import java.util.Random;

public class passengerArrival extends Thread {
	int type;
	public int maxlength;

	public passengerArrival(int t) {
		// TODO Auto-generated constructor stub
		type = t;
		maxlength = 0;
	}

	public void run() {

		while (mainClass.checkFlag) {
			// for 1 min
			try {
				sleep(2);
			} catch (InterruptedException e1) {

			}
			int rtime[] = new int[mainClass.r[type]];
			Random r = new Random();
			for (int i = 0; i < mainClass.r[type]; i++) {
				rtime[i] = r.nextInt(60);
			}
			Arrays.sort(rtime);
			int counter = 0;
			for (int i = 0; i < mainClass.r[type]; i++) {
				if (rtime[i] > counter) {
					try {
						Thread.sleep((rtime[i] - counter) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					counter = rtime[i];
					mainClass.q[type].enqueue();
					if (maxlength < mainClass.q[type].getLength()) {
						maxlength = mainClass.q[type].getLength();
					}
				}

			}
			try {
				Thread.sleep((60 - counter) * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// one minute ends
		}
	}
}
