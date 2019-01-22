import java.awt.Graphics;

import EasyShafts.Data.Data;
import EasyShafts.Methods.Buy;
import EasyShafts.Methods.Cut;
import xobot.client.callback.listeners.MessageListener;
import xobot.client.callback.listeners.PaintListener;
import xobot.client.events.MessageEvent;
import xobot.script.ActiveScript;
import xobot.script.Manifest;
import xobot.script.methods.tabs.Inventory;
import xobot.script.util.Time;

@Manifest(
        authors = { "IR0N" },
        name = "IR0N's EasyShafts",
        description = "Buys willows logs and cuts them into arrow shafts.")
public class EasyShafts extends ActiveScript implements PaintListener, MessageListener {

    String status = "";

    public boolean onStart() {
        return true;
    }


    @Override
    public int loop() {
        if (Inventory.Contains(Data.LOG_ID)) {
            if (Cut.canCut()) {
                status = "Cutting";
                Cut.doCut();
            }
        } else {
            if (Buy.canBuy()) {
                status = "Buying willow logs.";
                Buy.doBuy();
                Time.sleep(300);

            }
        }
        return 100;
    }

    @Override
    public void repaint(Graphics arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void MessageRecieved(MessageEvent event) {
        // TODO Auto-generated method stub
    }
}