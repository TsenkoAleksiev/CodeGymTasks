package com.codegym.games.minesweeper;

import com.codegym.engine.cell.Color;
import com.codegym.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y){
        if(isGameStopped){
            restart();
            return;
        }

        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y){
        markTile(x, y);
    }

    private void countMineNeighbors() {
        GameObject target;
        for (int row = 0; row < SIDE; row++) {
            for (int column = 0; column < SIDE; column++) {
                target = gameField[row][column];
                if (target.isMine) continue;
                for (GameObject neighbor : getNeighbors(target)) {
                    if (neighbor.isMine) {
                        target.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "BOOM! Game Over!", Color.WHITE, 40);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "Congrats! You won!", Color.BLACK, 40);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        countMinesOnField = 0;
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        int gy = gameObject.y;
        int gx = gameObject.x;
        for (int y = gy - 1; y <= gy + 1; y++) {
            if (y < 0) continue; // outside game board
            if (y >= SIDE) break; // outside game board
            for (int x = gx - 1; x <= gx + 1; x++) {
                if (x < 0) continue; // outside game board
                if (x == gx && y == gy) continue; // the same piece
                if (x >= SIDE) break; // outside game board
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void openTile(int x, int y){

        if(gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped) return;
                
        String emptyCell = "";
        boolean isCurrentMine = gameField[y][x].isMine;

        gameField[y][x].isOpen = true;
        countClosedTiles--;
        setCellColor(x, y, Color.GREEN);
        if(!isCurrentMine){
            score += 5;
            setScore(score);
        }

        if(isCurrentMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else if(gameField[y][x].countMineNeighbors >= 1) {
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
        }else{
            setCellValue(x, y, emptyCell);
            for (GameObject neighbor : getNeighbors(gameField[y][x])) {
                if (!neighbor.isOpen) openTile(neighbor.x, neighbor.y);
            }
        }
        if(countClosedTiles == countMinesOnField && !isCurrentMine) win();
    }

    private void markTile(int x, int y){
        boolean flagged = gameField[y][x].isFlag;
        if(isGameStopped) return;

        if(gameField[y][x].isOpen) return;
        if(!flagged && countFlags == 0) return;

        if(!flagged){
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }

        if(flagged){
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }
}