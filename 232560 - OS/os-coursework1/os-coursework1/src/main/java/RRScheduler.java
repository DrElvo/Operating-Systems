import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Round Robin Scheduler
 * 
 * @version 2017
 */

public class RRScheduler extends AbstractScheduler {

  // TODO
  private Queue<Process> readyQueue;
  private int timeQuantum;

  @Override
  public void initialize(Properties param) {

    this.timeQuantum = Integer.parseInt(param.getProperty("timeQuantum"));

  }

  public int getTimeQuantum() {

    return timeQuantum;

  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public RRScheduler() {

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

    return readyQueue.poll();
  }
}
