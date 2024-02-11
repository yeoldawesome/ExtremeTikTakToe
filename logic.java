package com.tiktaktoe;

public class logic {
	private String[][] Grid = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	
	public logic() {
		
	
	}
	
	public String getGrid(int Row, int Column) {
		return Grid[Row][Column];
		
	}
	
	public void setGrid(int Row, int Column, String Move){
		
	 Grid[Row][Column]= Move;
	}
	
	public int[] translateGrid (int Move) {
		int[] value = {0,0};
		int Row = 0;
		int Column = 0;
		 if (Move <= 3) {
 			 Row =0;
 		 }
 		 if (Move >= 4 && Move <=6  ) {
 			 Row =1;
 		 }
 		 if (Move >= 7) {
 			 Row =2;
 		 }
 		 
 		 if (Move == 1 || Move == 4||Move == 7) {
 			 Column =0;
 		 }
 		 if (Move == 2 || Move == 5||Move == 8) {
 			Column =1;
 		 }
 		 if (Move == 3 || Move == 6 ||Move == 9) {
 			Column =2;
 		 }
 		value[0]= Row;
 		value[1] = Column;
		return value;
	}
	
	public void printGrid() {
		
		for (int Row = 0; Row  <3; Row++) {
			
			for(int Column=0; Column!=3;Column++) {
				System.out.print(getGrid(Row, Column));
			}
			System.out.println("");
		}
		
	}
	
	public void checkWin() {
	for (int x = 0; x < 2; x++) {
	if(getGrid(x,0) == getGrid(x,1)&& getGrid(x,1)==getGrid(x,2) ) {
		System.out.println("Row " + getGrid(x,0) + " Win");
		
	}
	}
	for (int x = 0; x < 2; x++) {
	if(getGrid(0,x) == getGrid(1,x)&& getGrid(0,x)==getGrid(2,x) ) {
		System.out.println("Column " + getGrid(0,x) + " Win");
	}
	}
	if( getGrid(0,0) == getGrid(1,1)&& getGrid(0,0)==getGrid(2,2)) {
		System.out.println("Diagonal " + getGrid(1,1) + " Win");
	}
	if( getGrid(0,2) == getGrid(1,1)&& getGrid(0,2)==getGrid(2,0)) {
		System.out.println("Diagonal " + getGrid(1,1) + " Win");
	}
	}
	
	
	
}
