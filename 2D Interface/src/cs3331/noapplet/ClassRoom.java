package cs3331.noapplet;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class ClassRoom extends Applet {
    public ClassRoom() {
        setLayout(new BorderLayout());
        add(new JButton("Board"), BorderLayout.EAST);
        add(new JButton("Window"), BorderLayout.NORTH);
    }
}

