package com.tiktaktoe;

import java.util.Scanner;

public class MotherBoard {
	public Board[][] motherGrid = new Board[3][3];

	public MotherBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				motherGrid[i][j] = new Board();
			}

		}

	}

	public void printmotherGrid(String turn, int location) {

		for (int OutRow = 0; OutRow < 3; OutRow++) {
			for (int InRow = 0; InRow < 3; InRow++) {
				for (int OutColumn = 0; OutColumn < 3; OutColumn++) {
					for (int InColumn = 0; InColumn < 3; InColumn++) {
						System.out.print(motherGrid[OutRow][OutColumn].getGrid(InRow, InColumn));
					}
					System.out.print(" ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		getDaughterBoard(turn, location);
	}

	public void getDaughterBoard(String turn, int location) {
		checkMotherBoardWin();
		Board a = new Board();
		Scanner Input = new Scanner(System.in);
		int RowGrid = 0;
		int ColumnGrid = 0;
		int RowBox = 0;
		int ColumnBox = 0;
		String player = turn;
		if(motherGrid[a.translateGrid(location)[0]][a.translateGrid(location)[1]].checkFull(player)==1) {
			
			location = -1;
		}
		
		if (location == -1) {
			System.out.println("SELECT GRID PLAYER " + player);
			int moveGrid = Input.nextInt();
			RowGrid = a.translateGrid(moveGrid)[0];
			ColumnGrid = a.translateGrid(moveGrid)[1];
		} else {
			
			RowGrid = a.translateGrid(location)[0];
			ColumnGrid = a.translateGrid(location)[1];
			
		}
		motherGrid[RowGrid][ColumnGrid].printGrid();
		System.out.println("SELECT BOX PLAYER " + player);
		int moveBox = Input.nextInt();
		location = moveBox;
		RowBox = a.translateGrid(moveBox)[0];
		ColumnBox = a.translateGrid(moveBox)[1];
		motherGrid[RowGrid][ColumnGrid].setGrid(RowBox, ColumnBox, player);
		motherGrid[RowGrid][ColumnGrid].checkWin(player);
		if (player == "X") {
			player = "O";
		} else {
			player = "X";
		}
		printmotherGrid(player, location);

	}

	// needs to work 
	public void checkMotherBoardWin() {
		for (int x = 0; x < 3; x++) {
			if (motherGrid[x][0].getGrid(x,1) != motherGrid[x][1].getGrid(x,0)&& motherGrid[x][1].getGrid(x,1) != motherGrid[x][2].getGrid(x,1)) {
				System.out.print("K");

			}
		}
		for (int x = 0; x < 3; x++) {
			if (motherGrid[0][x] == motherGrid[1][x]&& motherGrid[1][x] == motherGrid[2][x]) {
				System.out.print("hey");
			}
		}
		if (motherGrid[0][0] == motherGrid[1][1] && motherGrid[0][0]  == motherGrid[2][2] ) {
			System.out.print("hey");
		}
		if (motherGrid[0][2] == motherGrid[1][1] && motherGrid[0][2]  == motherGrid[2][0]) {
			System.out.print("hey");
		}
	}
	
	}