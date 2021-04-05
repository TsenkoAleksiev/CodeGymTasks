package com.codegym.games.minesweeper;


public class GameObject {
    public int x;
    public int y;
    public boolean isMine;
    public int countMineNeighbors;
    public boolean isOpen;
    public boolean isFlag;
    
    public GameObject(int newX, int newY, boolean setMine){
        this.x = newX;
        this.y = newY;
        this.isMine = setMine;
    }
}