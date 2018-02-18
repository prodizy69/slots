package com.rss.pojo;

public class PlayWindow {
    private int cols;
    private int rows;
    private int[][] windowMatrix;

    public PlayWindow() {
    }

    public PlayWindow(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public int[][] getWindowMatrix() {
        return windowMatrix;
    }

    public void setWindowMatrix(int[][] windowMatrix) {
        this.windowMatrix = windowMatrix;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
