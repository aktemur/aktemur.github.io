class Hat {
    private Penguin owner;

    public void setOwner(Penguin p) {
        owner = p;
    }

    public String toString() {
        return owner + "'s hat";
    }
}

class Penguin extends Thread {
    private int id;
    private Penguin nextPenguin;
    private Hat hat;

    public Penguin(int id) {
        this.id = id;
    }

    public void setNextPenguin(Penguin nextPenguin) {
        this.nextPenguin = nextPenguin;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
        this.hat.setOwner(this);
    }
    
    public void swapHats() throws InterruptedException {
        System.out.println(this + " is swapping " + this.hat + " with " + nextPenguin.hat + ".");
        Hat temp = hat;
        this.setHat(nextPenguin.hat);
        sleep(10); // to make it easy to see a bug
        nextPenguin.setHat(temp);
    }

    public void run() {
        while(true) {
            try {
                swapHats();
            } catch (InterruptedException e) {
            }
        }
    }

    public String toString() {
        return "Penguin " + id;
    }
}

public class HatSwap {
    public static final int NUM_PENGUINS = 5;

    public static void main(String[] args) throws InterruptedException {
        Penguin[] penguins = new Penguin[NUM_PENGUINS];
        for (int i = 0; i < penguins.length; i++) {
            penguins[i] = new Penguin(i);
            penguins[i].setHat(new Hat());
        }

        for(int i = 0; i < penguins.length; i++) {
            penguins[i].setNextPenguin(penguins[(i+1) % NUM_PENGUINS]);
        }

        for (Penguin pen : penguins) {
            pen.start();
        }

        for (Penguin pen : penguins) {
            pen.join();
        }
    }
}
