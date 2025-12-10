import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SwingControlDemo implements ActionListener {
    private JFrame mainFrame;
    public JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private final int WIDTH=800;
    private final int HEIGHT=700;

    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));

        assert controlPanel != null;
        controlPanel = new JPanel();
        controlPanel.setSize(400,300);
        controlPanel.setLayout(new GridLayout(0,2));

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

//        mainFrame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0);
//            }
//        });

        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JLabel pokeName = new JLabel("      Waiting for Pokemon");
        JLabel pokeAbilities = new JLabel("     Waiting for Pokemon");

        JButton prevButton = new JButton("Prev");
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(new ButtonClickListener());
        nextButton.addActionListener(new ButtonClickListener());

        prevButton.setActionCommand("Prev");
        nextButton.setActionCommand("Next");

        mainFrame.add(pokeName);
        mainFrame.add(pokeAbilities);
        controlPanel.add(prevButton);
        controlPanel.add(nextButton);
        mainFrame.add(controlPanel);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Prev")) {

            }
            else if(command.equals("Next")){

            }
                try{
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        private BufferedReader getBufferedReader() {

            URL url = null;

            URLConnection urlc = null;
            try {
                urlc = url.openConnection();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(urlc.getInputStream())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return reader;
        }
    }