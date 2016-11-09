# dl-rover


## Assumptions/Interpretations

1. "the rover moves up to the last possible point and reports the obstacle" is interpreted to mean "the rover does not move and reports the obstacle".

## Prerequisites

1. [gradle](http://gradle.org/).  If you're on a Mac and have `brew`, you can run `brew install gradle` and then add `/usr/local/bin` to your `$PATH`.
2. [java](http:/java.com/). If you're on a Mac, you already have it, just make sure it's on your `$PATH`.

## To Build and Run

1. `gradle compileJava`
2. `java -cp build/classes/main com.dl.rover.Main`

