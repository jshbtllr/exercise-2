/*
 * CellTableFunction
 *
 * Main File
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.File;
import cell_key.Key;
import cell_value.Value;
import tablefunction.ManipulateTable;
import file_util.ProcessFile;

public class CellTableFunction {
	public static void main (String [] args) {
		int exit = 0;
		String fileName = "input.txt";
		ArrayList <LinkedHashMap <Key, Value>> myTable = new ArrayList <LinkedHashMap <Key, Value>>();
		
		myTable = ProcessFile.readFile(fileName, myTable);							//reads the file stores to myTable
		ManipulateTable.printTable(myTable);

		while (exit == 0) {
			System.out.println("");
			System.out.println("Menu");
			System.out.println("Search***********1");
			System.out.println("Edit*************2");
			System.out.println("Print************3");
			System.out.println("Reset************4");
			System.out.println("Add Row**********5");
			System.out.println("Sort Row*********6");
			System.out.println("Exit*************7");
			System.out.println("");
			
			System.out.print("Choose corresponding number to choose a Function: ");
			Scanner menu = new Scanner(System.in);
			String function = menu.nextLine();	
			myTable = ProcessFile.readFile(fileName, myTable);								//Constantly reads the file after a function was chosen
			
			switch (function) {
				case "1":												//Search Function	
					ManipulateTable.searchCell(myTable);
					break;
				case "2":												//Edit Function
					myTable = ManipulateTable.editCell(myTable);
					ProcessFile.writeFile(fileName,myTable);
					break;
				case "3":												//Print Function
					ManipulateTable.printTable(myTable);
					break;
				case "4":												//Reset Function
					myTable = ManipulateTable.resetTable();
					ProcessFile.writeFile(fileName,myTable);
					break;
				case "5":												//Add Row Function
					myTable = ManipulateTable.addRow(myTable);
					ProcessFile.writeFile(fileName,myTable);
					break;
				case "6":												//Sort Row Function
					myTable = ManipulateTable.sortRow(myTable);
					ProcessFile.writeFile(fileName,myTable);
					break;
				case "7":												//Exit
					exit = 1;
					break;
				
				default:										
					System.out.println(function + " is not a valid Function. Choose another function.");
					break;
			}
		}
	}
}
