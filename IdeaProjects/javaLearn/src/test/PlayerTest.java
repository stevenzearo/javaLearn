package test;

import day5.Lol.Equipment;
import day5.Lol.Hero;
import day5.Lol.Player;

import java.util.ArrayList;

public class PlayerTest {
    public static void main(String args[]) {
        Player player = new Player();
        player.setAccount("Steven0001");
        player.setCompeteId("comp-0001");
        player.setHeroUsed(new Hero("Riven","Warrior"));

        player.addEquipment(new Equipment("草鞋"));
        for (int i = 0; i < 100; i++) {
            player.addKilledSoldiers();
        }
        player.addKilledHeros();
        System.out.println("英雄等级:"+player.getHeroLevel());
        System.out.println("击杀数:"+player.getKilledHeroes());

    }
}
