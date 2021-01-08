/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_v2;

/**
 *
 * @author kahil
 */
public class Silver extends Levels {
    private double fee=20;
    private String lev="Silver";
    @Override
    public double fee(){
        return fee;
    }
    @Override
    public String lev(){
        return lev;
    }
    @Override
    public void changeLevels(Customer C){
        if(C.getbalance()<10000){
            C.setlevel(new Silver());
        }
        else if(C.getbalance()>=10000 && C.getbalance()<20000){
            C.setlevel(new Gold());
        }
        if(C.getbalance()>=20000){
            C.setlevel(new Platinum());
        }
    }
}
