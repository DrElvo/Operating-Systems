import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Feedback Round Robin Scheduler
 * 
 * @version 2017
 */
public class FeedbackRRScheduler extends AbstractScheduler {
  private Queue<Process> readyQueue;

  private int universalPriority;
  // TODO

  public FeedbackRRScheduler() {

    readyQueue = new LinkedList<Process>();

  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */

  public int getTimeQuantum() {
    if(universalPriority == 0){
      //System.out.println("8");
      return 8;
    }
    if(universalPriority == 1) {
      //System.out.println("16");
      return 16;
    }
    if(universalPriority == 2){
      //System.out.println("32");
      return 32;
    }
    //System.out.println("-1");
    return -1;
  }

  @Override
  public boolean isPreemptive() {
    return true;
  }

  public void ready(Process process, boolean usedFullTimeQuantum) {


    if (usedFullTimeQuantum == true) {

      process.setPriority(process.getPriority() + 1);

      // TODO
    }

    readyQueue.offer(process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */

  public Process schedule() {

    // TODO

    if(readyQueue.size() == 0){
      return null;
    }

      Process toProcess = readyQueue.peek();

      for (Process i : readyQueue) {

        if (toProcess.getPriority() > i.getPriority()) {

          universalPriority = i.getPriority();
          toProcess = i;

      }

    }

      if(toProcess != null) {
        readyQueue.remove(toProcess);
        return toProcess;
      }

    return null;




    }



}
