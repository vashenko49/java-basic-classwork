package com.classwork;

public class pickFinder {

    public int findFirstPick(int [] picks){
        if(picks.length<=0){
            return -1;
        }

        if(picks.length==1){
            return 1;
        }

        if(picks[0]>picks[1]){
            return 0;
        }

        int indexPick = -1;

        for (int i = 1; i < picks.length-2; i++) {
            if(picks[i]>picks[i+1]){
                indexPick =i;
            }
        }

        if(picks[picks.length-2]<picks[picks.length-1]){
            return picks.length-1;
        }

        return indexPick;
    }

    public int pickSum(int[] picks) {
        return -1;
    }
}
