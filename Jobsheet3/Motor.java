package Jobsheet3;

public class Motor {
    private int speed = 0;
    private boolean motorOn = false;

    public void startEngine() {
        motorOn = true;
    }

    public void trunOffEngine() {
        motorOn = false;
        speed = 0;
    }

    public void increaseEngine() {
        if (motorOn == true) {
            if (speed < 100) {
                speed += 10;
                if (speed > 100) {
                    speed = 100;
                }
            } else {
                System.out.println("Max speed!");
            }
        } else {
            System.out.println("Speed can't increase, because motor off");
        }
    }

    public void reduceEngine() {
        if (motorOn == true) {
            speed -= 5;
        } else {
            System.out.println("Motor cycle Off");
        }
    }

    public void statusPrint() {
        if (motorOn == true) {
            System.out.println("Motor cycle On");
        } else {
            System.out.println("Motor cycle Off");
        }
        System.out.println("Speed: " + speed + "\n");
    }
}
