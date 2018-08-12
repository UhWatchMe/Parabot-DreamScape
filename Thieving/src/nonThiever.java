

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import java.awt.*;
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

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    @Override
    public boolean onExecute() {

        if (stealAgain == 0 || stealAgain == 3) {
            stealAgain = 0;
            strategies.add(new Thief());
        }
        provide(strategies);
        return true;
    }


    @Override
    public void paint(Graphics graphics) {

    }

    @Override
    public void messageReceived(MessageEvent message) {
        if (message.getType() == 0){
            if (message.getMessage().contains("You stole a")){

            }
        }
    }
}