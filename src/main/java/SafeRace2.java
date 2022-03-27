public class SafeRace2 {
  private final Semafor semafor = new Semafor();
  private int counter = 0;

  public static void main(String[] args) {
    SafeRace2 race = new SafeRace2();
    long start = System.currentTimeMillis();
    int result = race.run();
    long duration = System.currentTimeMillis() - start;
    System.out.println("Result: " + result);
    System.out.println("Time: " + duration + "ms");
  }

  public int run() {
    Thread inc = new ThreadImpl(1);
    Thread dec = new ThreadImpl(-1);
    inc.start();
    dec.start();
    try {
      inc.join();
      dec.join();
      return counter;
    } catch (InterruptedException unused) {
      return 0;
    }
  }

  private class ThreadImpl extends Thread {
    private static final int OPS = 1000000;

    private final int delta;

    ThreadImpl(int delta) {
      this.delta = delta;
    }

    @Override public void run() {
      try {
        for (int i = 0; i < OPS; i++) {
          semafor.P();
          counter += delta;
          semafor.V();
        }
      } catch (InterruptedException unused) {
        // ignore
      }
    }
  }
}
