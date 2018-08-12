

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.Inventory;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * @author EmmaStone
 */
@ScriptManifest(
        author = "xBear",
        name = "nonThiever",
        category = Category.THIEVING,
        version = 1.0,
        description = "Thieves stalls at Edgeville or at Home.",
        servers = {"DreamScape"})
public class nonThiever extends Script implements Paintable, MessageListener {

    public static int stealAgain = 0;

    public static int check100M = 0;
    public static int check1B = 0;
    private long startTime;

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    @Override
    public boolean onExecute() {
        startTime = System.currentTimeMillis();
        strategies.add(new Thief());

        provide(strategies);
        return true;
    }

    public static String runTime(long i) {
        DecimalFormat nf = new DecimalFormat("00");
        long millis = System.currentTimeMillis() - i;
        long hours = millis / (1000 * 60 * 60);
        millis -= hours * (1000 * 60 * 60);
        long minutes = millis / (1000 * 60);
        millis -= minutes * (1000 * 60);
        long seconds = millis / 1000;
        return nf.format(hours) + ":" + nf.format(minutes) + ":"
                + nf.format(seconds);
    }


    @Override
    public void paint(Graphics g1) {
        g1.setColor(Color.GREEN);
        g1.drawString("Runtime: " + runTime(startTime), 50, 100);
        g1.drawString("1B checks stolen " + check1B, 50, 115);
    }



    @Override
    public void messageReceived(MessageEvent message) {
        if (message.getType() == 0){
            if (message.getMessage().contains("You stole a 100m check")){
                if (Inventory.getItem(5023) != null) {
                    check100M = Inventory.getCount(5023);
                    System.out.println("100M Checks Count " + check100M);
                }
            }

            if (message.getMessage().contains("You stole a 1bil check")){
                if (Inventory.getItem(5022) != null) {
                    check1B = Inventory.getItem(5022).getStackSize();
                    System.out.println("1B Checks Count " + check1B);
                }
            }
        }
    }
}