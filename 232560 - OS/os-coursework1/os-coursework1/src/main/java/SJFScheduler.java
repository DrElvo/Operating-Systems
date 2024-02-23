import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Random;

/**
 * Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class SJFScheduler extends AbstractScheduler {

  // TODO

  private Queue<Process> readyQueue;
  private Random rand = new Random();
  private double shortestTime = 10; //Initial burst estimate
  private double α = 0.5; // Alpha burst estimate
  private double lastShortestTime = shortestTime;

  private Process lastShortestProcess;


  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public SJFScheduler() {
    readyQueue = new LinkedList<Process>();
  }

  public void ready(Process process, boolean usedFullTimeQuantum) {

    // TODO

    readyQueue.offer(process);

  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {

    Process shortestProcess = null;
    Process toOffer = null;
    double predictedValue = 0;
    toOffer = readyQueue.peek();
    shortestTime = -1;

    for (Process i:readyQueue) {
      predictedValue = (α * i.getRecentBurst()) + ((1 - α)*lastShortestTime);

      if(predictedValue < shortestTime || shortestTime == -1){
        shortestTime = predictedValue;
        shortestProcess = i;
      }

    }
    if(shortestProcess != null){
      toOffer = shortestProcess;
      //System.out.println(predictedValue);
    }

    if (toOffer != null){

      lastShortestTime = shortestTime;
    }
    lastShortestProcess = toOffer;

    readyQueue.remove(toOffer);

    // TODO

    return toOffer;
  }
}
