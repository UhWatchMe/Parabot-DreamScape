import com.sun.media.jfxmedia.events.PlayerStateEvent;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.accessors.Player;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.SceneObject;


/**
 * Made by: Paradox
 * Copyright (c) $today.year.
 */

public class Thief implements Strategy {

public static int thievingLevel = 0;
    @Override
    public boolean activate() {



        for (SceneObject i : SceneObjects.getNearest(4874, 4875, 4876, 4877, 4878)) {
            if (i !=null && Players.getMyPlayer().getAnimation() == -1) {

                return true;
            }
        }
        return false;
    }

    @Override
    public void execute() {

        thievingLevel = Skill.THIEVING.getLevel();
        System.out.println("Current Thieving Level " + thievingLevel);

        for (SceneObject i : SceneObjects.getNearest(4874, 4875, 4876, 4877, 4878)) {
            if (thievingLevel < 50) {
               if (i.getId() == 4874){
                   System.out.println("Level is lower than 50, stealing from Crafting Stall.");
                   i.interact(0);
                   Time.sleep(3000);
               }
            }

            if (thievingLevel < 70 && thievingLevel > 49) {
                if (i.getId() == 4875){
                    System.out.println("Level is lower than 70, stealing from Food Stall.");
                    i.interact(0);
                    Time.sleep(3000);
                }
            }

            if (thievingLevel < 85 && thievingLevel > 69) {
                if (i.getId() == 4876){
                    System.out.println("Level is lower than 85, stealing from General Stall.");
                    i.interact(0);
                    Time.sleep(3000);
                }
            }

            if (thievingLevel < 99 && thievingLevel > 84) {
                if (i.getId() == 4877){
                    System.out.println("Level is lower than 99, stealing from Magic Stall.");
                    i.interact(0);
                    Time.sleep(3000);
                }
            }

            if (thievingLevel == 99) {
                if (i.getId() == 4878){
                    System.out.println("Level is 99, stealing from Scimitar Stall.");
                    i.interact(0);
                    Time.sleep(3000);
                }
            }
        }
    }
}