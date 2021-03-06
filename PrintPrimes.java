public class PrintPrimes {
  int numberOfPrimes;
  int listOfPrimes[];
  int listOfMultiples[];
 
  int linesPerColumn;
  int columnsPerPage;
  int pageNumber = 1;

  public PrintPrimes(int numberOfPrimes, int linesPerColumn, int columnsPerPage) {
    this.numberOfPrimes = numberOfPrimes;
    this.listOfPrimes = new int[numberOfPrimes + 1];
    this.listOfMultiples[] = new int[numberOfPrimes + 1];
    
    this.linesPerColumn = linesPerColumn;
    this.columnsPerPage = columnsPerPage;
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
      boolean isCrossedOff;
      int currentIndex;

      int currentNumber = 1;
      int largestMultipleIndex = 2;
      int squareOfPrimeToCheck = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == squareOfPrimeToCheck) {
            listOfMultiples[largestMultipleIndex] = currentNumber;
            largestMultipleIndex = largestMultipleIndex + 1;
            squareOfPrimeToCheck = listOfPrimes[largestMultipleIndex] * listOfPrimes[largestMultipleIndex];
          }
          currentIndex = 2;
          isCrossedOff = false;
          while (currentIndex < largestMultipleIndex && !isCrossedOff) {
            while (listOfMultiples[currentIndex] < currentNumber)
              setNextMultipleToCheck(currentIndex);
            if (listOfMultiples[currentIndex] == currentNumber)
              isCrossedOff = true;
            currentIndex = currentIndex + 1;
          }
        } while (isCrossedOff);
        listOfPrimes[primesFoundSoFar] = currentNumber;
      }
    }

    
    public void setNextMultipleToCheck( int index ) {
    	listOfMultiples[index] = listOfMultiples[index] + listOfPrimes[index] + listOfPrimes[index];
    }
    
    
    public void printPrimes() {
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          printCurrentPageHeading();
          printCurrentPagePrimes(pageOffset);
          pageOffset = pageOffset + linesPerColumn * columnsPerPage;
        }
    }
    
    public void printCurrentPageHeading() {
    	  System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          pageNumber = pageNumber + 1;
    }
    
    public void printCurrentPagePrimes( int startingIndex ) {
    	for (int rowOffset = startingIndex; rowOffset < startingIndex + linesPerColumn; rowOffset++){
            for (int i = 0; i < columnsPerPage; i++)
              if (rowOffset + i * linesPerColumn <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + i * linesPerColumn]);
            System.out.println("");
          }
          System.out.println("\f");
    }
}

					 
