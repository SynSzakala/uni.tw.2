class Semafor {
  private boolean free = true;
  private int waiting = 0;

  // zablokuj semafor
  public synchronized void P() throws InterruptedException {
    if (free) {
      free = false;
    } else {
      waiting++;
      wait();
      waiting--;
    }
  }

  // zwolnij semafor
  public synchronized void V() {
    if(waiting > 0) {
      // przynajmniej jeden thread czeka
      notify();
    } else {
      // zadnen thread nie czeka
      free = true;
    }
  }
}





