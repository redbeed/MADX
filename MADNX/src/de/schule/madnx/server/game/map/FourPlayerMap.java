/**
 * 
 */
package de.schule.madnx.server.game.map;


import java.util.ArrayList;
import java.util.Arrays;

import de.schule.madnx.server.game.Field;
import de.schule.madnx.server.game.GameMap;


/**
 * @author xgadscj
 *
 */
public class FourPlayerMap implements FieldMap{
	private int[][] map = {  { 4, 2 }, { 4, 3 }, { 4, 4 }, { 3, 4 }, { 2, 4 }, { 1, 4 }, { 1, 5 }, { 1, 6 },
			{ 1, 7 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 4, 9 }, { 4, 10 }, { 4, 11 }, { 5, 11 }, { 6, 11 },
			{ 7, 11 }, { 8, 10 }, { 8, 9 }, { 8, 8 }, { 9, 8 }, { 10, 8 }, { 11, 8 }, { 11, 7 }, { 11, 6 },
			{ 11, 5 }, { 10, 4 }, { 9, 4 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 7, 1 }, { 6, 1 },
			{ 5, 1 } };
	private int[][] redSpawn = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	private int[][] blueSpawn = { { 0, 11 }, { 0, 12 }, { 1, 11 }, { 1, 12 } };
	private int[][] greenSpawn = { { 11, 11 }, { 11, 12 }, { 12, 11 }, { 12, 12 } };
	private int[][] yellowSpawn = { { 11, 0 }, { 12, 0 }, { 11, 1 }, { 12, 1 } };
	private int[][] redFinish = { { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 } };
	private int[][] blueFinish = { { 2, 6 }, { 3, 6 }, { 4, 6 }, { 5, 6 } };
	private int[][] greenFinish = { { 6, 7 }, { 6, 8 }, { 6, 9 }, { 6, 10 } };
	private int[][] yellowFinish = { { 7, 6 }, { 8, 6 }, { 9, 6 }, { 10, 6 } };
	private int[][] redStart = { { 4, 1 } };
	private int[][] blueStart = { { 1, 8 } };
	private int[][] greenStart = { { 8, 11 } };
	private int[][] yellowStart = { { 11, 4 } };
	
	public void createFields(GameMap gameMap) {
		int zaehler = 0;
		Field[] fields = new Field[76];
		
		for(int[] i : this.map){
			fields[zaehler] = new Field(Field.Type.PATH, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.redSpawn){
			fields[zaehler] = new Field(Field.Type.SPAWN, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.blueSpawn){
			fields[zaehler] = new Field(Field.Type.SPAWN, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.greenSpawn){
			fields[zaehler] = new Field(Field.Type.SPAWN, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.yellowSpawn){
			fields[zaehler] = new Field(Field.Type.SPAWN, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.redStart){
			fields[zaehler] = new Field(Field.Type.START, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.blueStart){
			fields[zaehler] = new Field(Field.Type.START, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.greenStart){
			fields[zaehler] = new Field(Field.Type.START, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.yellowStart){
			fields[zaehler] = new Field(Field.Type.START, zaehler, i[0], i[1]);
			zaehler++;
		}
		for(int[] i : this.redFinish){
			fields[zaehler] = new Field(Field.Type.FINISH, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.blueFinish){
			fields[zaehler] = new Field(Field.Type.FINISH, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.greenFinish){
			fields[zaehler] = new Field(Field.Type.FINISH, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		for(int[] i : this.yellowFinish){
			fields[zaehler] = new Field(Field.Type.FINISH, zaehler, i[0], i[1]);
			zaehler++;
		}
		
		gameMap.fields = Arrays.asList(fields);
	}

	@Override
	public int[][] getMapAsArray() {
		return map;
	}

	@Override
	public ArrayList<int[][]> getFieldsForPlayerList() {
		ArrayList<int[][]> result = new ArrayList<>();
		int[][] helpArray = new int[9][2];
		System.arraycopy(redSpawn, 0, helpArray, 0, redSpawn.length);
		System.arraycopy(redFinish, 0, helpArray, redSpawn.length, redFinish.length);
		System.arraycopy(redStart, 0, helpArray, redSpawn.length + redFinish.length, redStart.length);
		result.add(helpArray);
		helpArray = new int[9][2];
		System.arraycopy(blueSpawn, 0, helpArray, 0, blueSpawn.length);
		System.arraycopy(blueFinish, 0, helpArray, redFinish.length, blueFinish.length);
		System.arraycopy(blueStart, 0, helpArray, blueSpawn.length + blueFinish.length, blueStart.length);
		result.add(helpArray);
		helpArray = new int[9][2];
		System.arraycopy(greenSpawn, 0, helpArray, 0, greenSpawn.length);
		System.arraycopy(greenFinish, 0, helpArray, greenSpawn.length, greenFinish.length);
		System.arraycopy(greenStart, 0, helpArray, greenSpawn.length + greenFinish.length, greenStart.length);
		result.add(helpArray);
		helpArray = new int[9][2];
		System.arraycopy(yellowSpawn, 0, helpArray, 0, yellowSpawn.length);
		System.arraycopy(yellowFinish, 0, helpArray, yellowSpawn.length, yellowFinish.length);
		System.arraycopy(yellowStart, 0, helpArray, yellowSpawn.length + yellowFinish.length, yellowStart.length);
		result.add(helpArray);
		return result;
	}
	
	public ArrayList<int[][]> getSpawnForFigureList() {
		ArrayList<int[][]> result = new ArrayList<>();
		
		result.add(redSpawn);
		result.add(blueSpawn);
		result.add(greenSpawn);
		result.add(yellowSpawn);
		
		return result;
	}
}
