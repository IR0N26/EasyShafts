package EasyShafts.Methods;

import EasyShafts.Data.Data;
import EasyShafts.Utils.Methodes;
import EasyShafts.Utils.SleepCondition;
import xobot.script.methods.Widgets;

import xobot.script.methods.tabs.Inventory;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.Player;
import xobot.script.methods.Packets;
import xobot.script.wrappers.interactive.Item;

import java.awt.event.KeyEvent;

public class Cut {
    static int logSlot = Inventory.getItem(Data.LOG_ID).getSlot();
    static int knifeSlot = Inventory.getItem(Data.KNIFE_ID).getSlot();

    public static boolean canCut() {
        Item itemToCut = Inventory.getItem(Data.LOG_ID);
        return itemToCut != null;
    }

    public static void doCut() {

        if (Player.getMyPlayer().getAnimation() == -1 && !Player.getMyPlayer().isMoving()) {
            if (Inventory.Contains(Data.KNIFE_ID)) {
                Packets.sendAction(447, Data.KNIFE_ID, knifeSlot, 3214);
                Packets.sendAction(870, Data.LOG_ID, logSlot, 3214);

                if (Time.sleep(() -> Widgets.getBackDialogId() == 8938, 5000)) {
                    System.out.println("Fletching interface is open!");
                    Time.sleep(200);
                    Packets.sendAction(315, 1519, -1, 8954); // Arrow Shaft packet
                    System.out.println("Cutting arrow shafts!");
                    Methodes.conditionalSleep(new SleepCondition() {
                        @Override
                        public boolean isValid() {
                            return !Inventory.Contains(Data.LOG_ID);
                        }
                    }, 20000);
                }
            } else {
                System.out.println("No knife in inventory!");
                Time.sleep(2000);

            }
        }
    }
}


