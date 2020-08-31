
// Q3
boolean canSeePlayer;
boolean playerPoweredUp;

if (canSeePlayer) {
    if (!playerPoweredUp) {
        System.out.println("Attack!");
    } else {
        System.out.println("Run away!");
    }
} else {
    System.out.println("Wander.");
}

// Q4
boolean isSnowing = false;
boolean isRaining = true;
double temperature = 60.0;

if (isSnowing || isRaining || temperature < 50) {
    System.out.println("Let's stay home.");
} else {
    System.out.println("Let's go out!");
}

// Q5
double time = 18;
String timeOfDay;

if (time >=5 && time < 12) {
    timeOfDay = "morning";
} else if (time >= 12 && time < 20) {
    timeOfDay = "daytime";
} else {
    timeOfDay = "night";
}


// Q6
int weekday = 5;
boolean holiday = false;

if (weekday >= 1 && weekday <= 5 && !holiday) {
    System.out.println("Wake up at 7:00");
} else {
    System.out.println("Sleep in!");
}

// Q8
int dayOfWeek;
String Schedule;

switch (dayOfWeek) {
    case 1 : Schedule = "Gym in the morning.";
        break;
    case 2: Schedule = "Class after work.";
        break;
    case 3: Schedule = "Mettings all day.";
        break;
    case 4: Schedule = "Work from home.";
        break;
    case 5: Schedule = "Game night after work.";
        break;
    case 6: case 7: default: Schedule = "Free!";
        break;      
}

// println definition
public void println(String x) {
    // check that the String exists
    if (x == null) {
        x = "null";
    }
    try {
        ensureOpen();
        // write String to screen
        textOut.write(x);
    } catch (IOException e) {
        trouble = true;
    }
    newLine();
}

// public <return type> <function name> () {
//     <block of code>
// }

public void chorus() {
    System.out.println("Once I had a love and it was a gas");
    System.out.println("Soon turned out had a heart of glass");
    System.out.println("Seemed like the real thing, only to find");
    System.out.println("Mucho mistrust, love's gone behind");
}

boolean playButton = false;

public void playMusic(boolean playButton) {
    if (playButton) {
        System.out.println("Music is playing");
    } else {
        System.out.println("Music is paused");
    }
}

public void greeting(String location) {
    System.out.println("Hello " + location);
}

public void printPhoto(int width, int height, boolean inColor) {
    System.out.println("Width = " + width + " cm");
    System.out.println("Height = " + height + " cm");
    if (inColor) {
        System.out.println("Print is full color.");
    } else {
        System.out.println("Print is black and white");
    }
}

printPhoto(10, 20, false);

public void likePhoto(int currentLikes, String comment, boolean like) {
    // prints out comment and who is commenting
    System.out.println("Feedback: " + comment);
    if (like) {
        // increase number of likes by 1
        currentLikes = currentLikes + 1;
    }
    System.out.println("Number of likes:" + currentLikes);
}

// 返回currentLikes
public int likePhoto(int currentLikes, String comment, boolean like) {
    // prints out comment and who is commenting
    System.out.println("Feedback: " + comment);
    if (like) {
        // increase number of likes by 1
        currentLikes = currentLikes + 1;
    }
    System.out.println("Number of likes:" + currentLikes);
    return currentLikes;
}

public double makeChange(double itemCost, double dollarsProvided) {
    double change = dollarsProvided - itemCost;
    return change;
}

// 六面体
public int rollDice() {
    // random num between 0 and (almost) 1
    double randomNumber = Math.random();

    // change range to 0 to almost 6
    randomNumber = randomNumber * 6;

    // shift range up one
    randomNumber = randomNumber + 1;

    // cast to integer (ignore decimal part) 
    int randomInt = (int) randomNumber;

    // return statement
    return randomInt;
}


public int rollDice(int sides) {
    // random num between 0 and (almost) 1
    double randomNumber = Math.random();

    // change range to 0 to almost 
    randomNumber = randomNumber * sides;

    // shift range up one
    randomNumber = randomNumber + 1;

    // cast to integer (ignore decimal part) 
    int randomInt = (int) randomNumber;

    // return statement
    return randomInt;
}

// Martingale strategy
public int martingale(){
    int money = 1000;
    int target = 1200;
    int bet = 10;
    while (money > bet) {
        if (money >= target) 
            break;
        boolean win = play();
        if (win) {
            money += bet;
            bet = 10;
        } else {
            money -= bet;
            bet *= 2;
        }
    }
    return money;
}

String [] newsOutlet = {'a', 'b', 'c', 'd', 'e',
                        'f', 'g', 'h', 'i', 'j'};
double lucky = Math.random();
lucky *= 10;
int luckyIndex = (int) lucky;
System.out.println(newsOutlet[luckyIndex]);

public double search(double[] speed) {
    int size = speed.length;
    double min = speed[0];
    for (int i = 1; i < size; i++) {
        if (speed[i] < min) {
            min = speed[i];
        }
    }
    return min;
}

public String findLongestName(String [] names) {
    int size = names.length; // 数组的长度
    String longest = names[0];
    for (int i = 1; i < size; i++) {
        if (names[i].length() > longest.length()) {
            longest = names[i];
        }
    }
    return longest;
}

public static double studentAverage(int [][] grades, int student) {
    int total = 0;
    int subjects = grades.length;
    for (int i=0; i<subjects; i++) {
        total += grades[i][student];
    }
    double average = total / (double)subjects;
    return average;
}



