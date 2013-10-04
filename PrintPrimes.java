public class PrintPrimes {
  int numberOfPrimes;
  int linesPerColumn
  int columnsPerPage;
  int listOfPrimes[];
  int listOfMultiples[];

  public PrintPrimes(int numberOfPrimes, int RR, int CC) {
    this.numberOfPrimes   = numberOfPrimes;
    this.RR  = RR;
    this.CC  = CC;
    this.listOfPrimes = new int[numberOfPrimes + 1];
    listOfMultiples[] = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean isCurrentNumberPrime;
      int N;

      int currentNumber = 1;
      int index = 2;
      int squareOfPrimeToCheck = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == squareOfPrimeToCheck) {
            listOfMultiples[index] = currentNumber;
            index = index + 1;
            squareOfPrimeToCheck = listOfPrimes[index] * listOfPrimes[index];
          }
          N = 2;
          isCurrentNumberPrime = true;
          while (N < index && isCurrentNumberPrime) {
            while (listOfMultiples[N] < currentNumber)
              listOfMultiples[N] = listOfMultiples[N] + listOfPrimes[N] + listOfPrimes[N];
            if (listOfMultiples[N] == currentNumber)
              isCurrentNumberPrime = false;
            N = N + 1;
          }
        } while (!isCurrentNumberPrime);
        listOfPrimes[primesFoundSoFar] = currentNumber;
      }
    }

    public void printPrimes() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + linesPerColumn; ROWOFFSET++){
            for (int C = 0; C < columnsPerPage;C++)
              if (ROWOFFSET + C * linesPerColumn <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * linesPerColumn]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + linesPerColumn * columnsPerPage;
        }
    }
}

					 
