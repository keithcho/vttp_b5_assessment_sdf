## Run

### Task 1
From the root folder, run the following command:

```powershell
cd task01 && javac -d classes --source-path src src/vttp/batch5/sdf/task01/Main.java && java -cp classes vttp.batch5.sdf.task01.Main <optional .csv path>
```

You may specify an optional custom path to a `.csv` file as parameter. The program will default to the path given in the assessment template.

### Task 2

From the root folder, run the following command:

```powershell
cd task02 && javac -d classes --source-path src src/vttp/batch5/sdf/task02/Main.java && java -cp classes vttp.batch5.sdf.task02.Main TTT/figure1.txt
```

Replace `TTT/figure1.txt` with paths to your board configuration.

## Breakdown

### Task 1

1. A static method `readCSV` reads the `.csv` file using a `BufferedReader`. Each line is parsed using the `toBikeEntry` method provided in the template. A `TreeMap` is created with `totalCyclists` as the key, and `BikeEntry` as the value.

2. The `TreeMap` is sorted by descending order, and the program outputs the top 5 days with the most cyclists. An abstracted `OutputHelper` class is used to print the data in the required assessment format.

### Task 2

1. A static method `readBoard` reads the board configuration file into a 2D string array using a `BufferedReader`.

2. An `Evaluator` class is used to check the win conditions for any given player (O/X).

3. At each empty coordinate, the `checkUtility` method creates a temporary board and plays the next move. If a win condition is met, a positive utility of `+1` is returned.

4. If a move is placed and the opponent is able to win on the next turn without being blocked, a negative utility of `-1` is returned.

5. If no one wins in the next move, a neutral utility of `0` is returned.

6. The program prints the initial board state, followed by all legal positions and the corresponding utility.

## Extra Notes

For Task 2, `board4.txt` has an invalid board configuration. Since X moves on the next turn, there should be fewer Xs on the board than Os.

Therefore, if an invalid board configuration file is provided, the program will inform the user that the configuration is invalid.

Example:

```
Processing: TTT/board4.txt
>>> Invalid board configuration! Are you sure it's your turn? <<<

Board:
X.O
.O.
X.X
-----------------------
y=0, x=1, utility=0
y=1, x=0, utility=1
y=1, x=2, utility=0
y=2, x=1, utility=1
```