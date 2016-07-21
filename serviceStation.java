import java.util.Random;

public class serviceStation extends Thread {
	int type;
	public int totalTime;
	public int maxTime;
	public int count;
	public int countc;

	public serviceStation(int t) {
		// TODO Auto-generated constructor stub
		type = t;// t='0' for coach|t='1' for first
		countc = count = totalTime = maxTime = 0;
	}

	public void run() {

		while (mainClass.checkFlag) {
			try {
				sleep(2);
			} catch (InterruptedException e1) {

			}
			if (mainClass.q[type].dequeue()) {
				Random r = new Random();
				int time = r.nextInt(mainClass.ptime[0]) + 1;
				totalTime += time;
				count++;
				if (time > maxTime) {
					maxTime = time;
				}
				try {
					sleep(time * 1000);
				} catch (InterruptedException e) {

				}
			} else if (type == 1) {
				if (mainClass.q[0].dequeue()) {
					Random r = new Random();
					int time = r.nextInt(mainClass.ptime[0]) + 1;
					totalTime += time;
					countc++;
					if (time > maxTime) {
						maxTime = time;
					}
					try {
						sleep(time * 1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
