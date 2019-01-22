package EasyShafts.Methods;

import EasyShafts.Data.Data;
import xobot.script.methods.NPCs;
import xobot.script.methods.Shop;
import xobot.script.methods.tabs.Inventory;
import xobot.script.util.Time;
import xobot.script.wrappers.interactive.NPC;

public class Buy {

    public static boolean canBuy() {
        NPC shop = NPCs.getNearest(Data.SHOP_ID);
        return shop != null && shop.isReachable();

    }

    public static void doBuy() {
        NPC shop = NPCs.getNearest(Data.SHOP_ID);
        if (!shop.isReachable()) {

        }
        if (shop != null && !Shop.isOpen()) {
            shop.interact("trade");
            Time.sleep(() -> Shop.isOpen(), 8000);
        }

        if (Shop.isOpen()) {
            System.out.println("Buying willow logs.");
            Shop.buy(Data.LOG_ID, 28);
            Time.sleep(() -> Inventory.isFull(), 8000);
        }
    }

    public static boolean isAtShop(){
        NPC shop = NPCs.getNearest(Data.SHOP_ID);
        if (shop != null && shop.isReachable()){
            return true;
        }
        return false;
    }
}
