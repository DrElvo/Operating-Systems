import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Ideal Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

  private Queue<Process> readyQueue;
  // TODO

  public IdealSJFScheduler() {
    readyQueue = new LinkedList<Process>();
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
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
    // TODO
    if(readyQueue.size() == 0){
      return null;
    }

    int length = 0;
    int longestInt = readyQueue.peek().getNextBurst();
    Process toOffer = readyQueue.peek();
    for (Process i : readyQueue) {
      length = i.getNextBurst();
      if (longestInt > length) {
        toOffer = i;
      }

    }

    readyQueue.remove(toOffer);

    return toOffer;

    /**
     * When executing, the
     */

  }
}
