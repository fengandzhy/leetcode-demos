package org.frank.leetcode.array.plus.one.demo01;

public class ConstructionGame {
    private int height;
    private int length;
    private boolean[][] room;
    private int[] recorder;
    
    public ConstructionGame(int length, int width) {
        this.length = length;
        room = new boolean[length][width];
        recorder = new int[length * width];
    }

    public void addCubes(boolean[][] cubes) {        

        for(int i = 0; i < cubes.length; i ++){
            for(int j = 0; j < cubes[i].length; j ++){
                if(cubes[i][j]){
                    room[i][j] = true;
                    recorder[i*length + j] = recorder[i*length + j] + 1;
                }                
            }
        }
        boolean isFull = true;
        for(int i = 0; i < room.length; i ++) {
            for (int j = 0; j < room[i].length; j++) {
                if(!room[i][j]){
                    isFull = false;
                }
            }
        }
        for(int i = 0; i<recorder.length;i++){
            if(recorder[i] > height){
                height = recorder[i];
            }
        }
        if(isFull){
            for(int i = 0; i<recorder.length;i++){
                if(recorder[i] > 1){
                    room[i/length][i%length] = false;
                }
                recorder[i] = recorder[i] - 1;
            }
            height --;
        }
    }

    public int getHeight() {
        for(int i = 0; i<recorder.length;i++){
            if(recorder[i] > height){
                height = recorder[i];
            }
        }
        return height;
    }

    public static void main(String[] args) {
        ConstructionGame game = new ConstructionGame(2, 2);

        game.addCubes(new boolean[][] {
                { true, true },
                { true, false } });
        System.out.println(game.getHeight());
        
        game.addCubes(new boolean[][] {
                { true, true },
                { false, true } });
        System.out.println(game.getHeight()); // should print 2

        game.addCubes(new boolean[][] {
                { true, false },
                { true, true } });
        System.out.println(game.getHeight()); // should print 1
    }
}
