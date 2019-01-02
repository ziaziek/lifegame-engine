package com.pncomp.lifegame.domain;

import com.pncomp.lifegame.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the area containibg life fields @LifeField and organisms @Organism.
 */
public class LifeArea {

    public LifeField[][] getLifeFields() {
        return lifeFields;
    }

    private final LifeField[][] lifeFields;


    public LifeArea(LifeField[][] lifeFields) throws Exception {
        if(lifeFields.length!=lifeFields[0].length){
            throw new Exception("Life area must be a square.");
        }
        this.lifeFields = lifeFields;
    }

    public  LifeArea(){
        lifeFields=new LifeField[10][10];
    }

    public boolean isAdjacent(int m, int n, int a, int b){

        return ((Math.abs(m-a)==1 && n==b) || (Math.abs(n-b)==1 && m==a));

    }

    /**
     * Finds a vector of adjecent fields to the one specified by indices
     * @param m row index of the field
     * @param n column index of the field
     * @return vector of adjecent fields. Diagonal fields are not taken into account.
     */
    public LifeField[] adjacentFields(int m, int n){

        List<LifeField> fields = new ArrayList<>();

        for(int x = Math.max(0, m-1); x<=Math.min(lifeFields.length-1, m+1); x++){
            for(int y=Math.max(0, n-1); y<=Math.min(lifeFields.length-1, n+1); y++){
                if(!((x==m && y==n) || (x==m-1 && y==n-1) || (x==m+1 && y==n+1) || (x==m-1 && y==n+1) || (x==m+1 && y==n-1))){
                    fields.add(lifeFields[x][y]);
                }
            }
        }

        return fields.toArray(new LifeField[fields.size()]);
    }

    public void clear(){
        for (int i = 0; i < lifeFields.length; i++) {
            for (int j = 0; j < lifeFields[i].length; j++) {
                LifeField lifeField = lifeFields[i][j];
                lifeField.setOrg(null);
            }
        }
    }

    public Pair[] adjacentFieldsIndice(int m, int n){

        List<Pair> fields = new ArrayList<>();

        for(int x = Math.max(0, m-1); x<=Math.min(lifeFields.length-1, m+1); x++){
            for(int y=Math.max(0, n-1); y<=Math.min(lifeFields.length-1, n+1); y++){
                if(!((x==m && y==n) || (x==m-1 && y==n-1) || (x==m+1 && y==n+1) || (x==m-1 && y==n+1) || (x==m+1 && y==n-1))){
                    fields.add(new Pair(x,y));
                }
            }
        }

        return fields.toArray(new Pair[fields.size()]);
    }
}
