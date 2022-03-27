class BetterSemafor {
  private boolean acquired = false;

  public synchronized void P() throws InterruptedException {
    while (acquired) wait();
    acquired = true;
  }

  public synchronized void V() {
    acquired = false;
    notify();
  }
}