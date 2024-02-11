package com.tiktaktoe;

public class Board {
	public String[][] Grid = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

	public Board() {

	}

	public String getGrid(int Row, int Column) {
		return Grid[Row][Column];

	}

	public void setGrid(int Row, int Column, String Move) {

		Grid[Row][Column] = Move;
	}

	public int[] translateGrid(int Move) {
		int[] value = { 0, 0 };
		int Row = 0;
		int Column = 0;
		if (Move <= 3) {
			Row = 0;
		}
		if (Move >= 4 && Move <= 6) {
			Row = 1;
		}
		if (Move >= 7) {
			Row = 2;
		}

		if (Move == 1 || Move == 4 || Move == 7) {
			Column = 0;
		}
		if (Move == 2 || Move == 5 || Move == 8) {
			Column = 1;
		}
		if (Move == 3 || Move == 6 || Move == 9) {
			Column = 2;
		}
		value[0] = Row;
		value[1] = Column;
		return value;
	}

	public void printGrid() {

		for (int Row = 0; Row < 3; Row++) {

			for (int Column = 0; Column < 3; Column++) {
				System.out.print(Grid[Row][Column]);
			}
			System.out.println("");
		}

	}

	public int checkWin(String player) {
		for (int x = 0; x < 3; x++) {
			if (getGrid(x, 0) == getGrid(x, 1) && getGrid(x, 1) == getGrid(x, 2)) {
				
				for (int k = 0; k < 3; k++) {
					for (int i = 0; i < 3; i++) {
						Grid[k][i] = player;
					}
				}

			}
		}
		for (int x = 0; x < 3; x++) {
			if (getGrid(0, x) == getGrid(1, x) && getGrid(0, x) == getGrid(2, x)) {
				
				for (int k = 0; k < 3; k++) {
					for (int i = 0; i < 3; i++) {
						Grid[k][i] = player;
					}
				}
			}
		}
		if (getGrid(0, 0) == getGrid(1, 1) && getGrid(0, 0) == getGrid(2, 2)) {
			
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					Grid[k][i] = player;
				}
			}
		}
		if (getGrid(0, 2) == getGrid(1, 1) && getGrid(0, 2) == getGrid(2, 0)) {
			
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 3; i++) {
					Grid[k][i] = player;
				}
				
			}
			return 1;
		}
		return 0;
	}

	public int checkFull(String player ) {
		for (int x = 0; x < 3; x++) {
			if (getGrid(x, 0) == getGrid(x, 1) && getGrid(x, 1) == getGrid(x, 2)) {
				return 1;
			}
		}
		for (int x = 0; x < 3; x++) {
			if (getGrid(0, x) == getGrid(1, x) && getGrid(0, x) == getGrid(2, x)) {
				return 1;
			}
		}
		if (getGrid(0, 0) == getGrid(1, 1) && getGrid(0, 0) == getGrid(2, 2)) {
			return 1;
		}
		if (getGrid(0, 2) == getGrid(1, 1) && getGrid(0, 2) == getGrid(2, 0)) {
			return 1;
		}
		return 0;
	}

}
