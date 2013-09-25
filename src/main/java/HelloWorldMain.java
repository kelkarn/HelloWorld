

public class HelloWorldMain {

    private static int MINS_IN_HOUR = 60;

    public static void main(String [] args) {

        System.out.println("Hello World!");

        System.out.println("test --> " + putInTimeBand("01:18", 25));

    }

    public static String putInTimeBand(String time, int minuteWindow) { // timeband function

        if (MINS_IN_HOUR%minuteWindow != 0) {

            throw new IllegalArgumentException("Error: minute window provided does not divide an hour completely."
                                                + "Please check argument (2) in putInTimeBand(String, int)");
        }

        int nWindows = MINS_IN_HOUR/minuteWindow;
        int mm = Integer.parseInt(time.substring(3));
        for (int i=0;i<nWindows;i++) {
           if ((i*minuteWindow <= mm) && (mm < (i+1)*minuteWindow)) {
               return (time.substring(0, 2) + ":" + String.format("%02d", i*minuteWindow));
           }

        }

        return null; // the program should never reach here!
    }


}
