import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtnExit = new JButton("Exit");
    private JPanel statusPane = new JPanel(new GridLayout(1,5,3,3));
    private JPanel funtionPane = new JPanel(new GridLayout(1,5,3,3));
    private ImageIcon icons[] = new ImageIcon[2];
    private JLabel jlbDBstatus = new JLabel();
    private DBConn dbconn;
    private JButton jbtnAll = new JButton("All");
    private JButton jbtnInsert = new JButton("Insert");
    private JButton jbtnUpdate = new JButton("Update");
    private JButton jbtnDelete = new JButton("Delete");
    private JButton jbtnSearch = new JButton("Search");
    private JButton jbtnDBConnect = new JButton("Connect");
    private JTextArea jta = new JTextArea();
    private JScrollPane jsp = new JScrollPane(jta);

    public MainFrame(){
        init();
    }

    public void init(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setBounds(100,100,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.add(statusPane, BorderLayout.SOUTH);
        cp.add(funtionPane, BorderLayout.NORTH);
        cp.add(jsp, BorderLayout.CENTER);

        jta.setEditable(false);

        icon[0] = new ImageIcon("./src/Red_Ball.png");
        icon[1] = new ImageIcon("./src/Green_Ball.png");

        Image img1 = icon[0].getImage();
        Image img2 = img1.setScaledInstance(32,32, Image.SCALE_SMOOTH);
        icon[0].setImage(img2);
        jlbDBstatus.setIcon(icon[0]);

        img1 = icon[1].getImage();
        img2 = img1.setScaledInstance(32,32, Image.SCALE_SMOOTH);
        icon[0].setImage(img2);

        funtionPane.add(jbtnAll);
        funtionPane.add(jbtnInsert);
        funtionPane.add(jbtnUpdate);
        funtionPane.add(jbtnDelete);
        funtionPane.add(jbtnSearch);

        statusPane.add(jlbDBstatus);
        statusPane.add(jbtnDBConnect);
        statusPane.add(jbtnExit);

        jbtnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });

        jbtnDBConnect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JButton jbtn = (JButton) ae.getSource();
                if(dbconn == null){
                    dbconn = new DBConn();
                    jlbDBstatus.setIcon(icon[0]);
                    jbtn.setText("Connect");
                }
            }
        });

        jbtnAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jta.append(dbconn.showAll());
            }
        });
    }
}