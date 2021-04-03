package com.codegym.games.minesweeper;

import com.codegym.engine.cell.Color;
import com.codegym.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
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
            }
        }
        countMineNeighbors();
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
}