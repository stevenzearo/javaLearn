package day5.Lol;

import java.util.ArrayList;
/*
*
* */

public class Player {

    private String account;
    private String competeId;
    private Hero heroUsed;
    private ArrayList<Equipment> equipList = new ArrayList<Equipment>();
    private int assists = 0;
    private int deaths = 0;
    private int killedHeroes = 0;
    private int killedSoldiers = 0;
    private int scoreInCom = 0;
    private int scoreHistory = 0;
    private int heroLevel = 1;
    private final int heroLevelMaxInCom = 30;
    public void setAccount(String account){
        this.account = account;
    }
    public void setCompeteId(String competeId){
        this.competeId = competeId;
    }
    public void setHeroUsed(Hero heroUsed){
        this.heroUsed = heroUsed;
    }
//    每添加一件装备时实时得分加5
    public void addEquipment(Equipment equipment){
        this.equipList.add(equipment);
        this.scoreInCom += 5;
        this.scoreHistory += 5;
        this.setHeroLevel();
    }
    public void addAssists(){
        this.assists += 1;
        this.scoreInCom += 10;
        this.scoreHistory += 10;
        this.setHeroLevel();
    }
    public void addDeaths() {
        this.deaths += 1;
    }
    public void addKilledHeros() {
        this.killedHeroes += 1;
        this.scoreInCom += 20;
        this.scoreHistory += 20;
        this.setHeroLevel();
    }
    public void addKilledSoldiers() {
        this.killedSoldiers += 1;
        this.scoreInCom += 2;
        this.scoreHistory += 2;
        this.setHeroLevel();
    }
//    更新英雄等级
    private void setHeroLevel() {
        for (int i = 100; i <= 3000; i += 100) {
            if (this.scoreInCom < i){
                this.heroLevel = i/100;
                break;
            }
        }
        if (this.scoreInCom >= 3000) {
            this.heroLevel = heroLevelMaxInCom;
        }
    }

    public String getAccount(){
        return account;

    }
    public String getCompeteId(){
        return competeId;
    }
    public Hero getHeroUsed(){
        return heroUsed;
    }
    public ArrayList<Equipment> getEquipList(){
        return equipList;
    }

    public int getAssists() {
        return assists;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getKilledHeroes() {
        return killedHeroes;
    }

    public int getKilledSoldiers() {
        return killedSoldiers;
    }

    public int getScoreInCom() {
        return scoreInCom;
    }

    public int getScoreHistory() {
        return scoreHistory;
    }

    public int getHeroLevel() {
        return heroLevel;
    }
}
