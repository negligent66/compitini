import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTraduzione extends JFrame {
    //cose GUI
    private JPanel mainPanel;
    private JButton ENGLISHITALIANOButton;
    private JButton ITALIANOENGLISHButton;
    private JFormattedTextField formattedTextField1;
    private JButton TRADUCIButton;
    private JTextField originale;
    private JTextField traduzione;
    private JButton CLEARButton;
    //cose traduttore
    private boolean switchino = true;

    public MainTraduzione(){
        TesterTraduttore.inserimentoArraylistIng();
        TesterTraduttore.inserimentoArrayListIta();
        TesterTraduttore.alberinoIta.insertBalanced(TesterTraduttore.paroleDelFileIta);
        TesterTraduttore.alberinoIng.insertBalanced(TesterTraduttore.paroleDelFileIng);

        setContentPane(mainPanel);
        setTitle("Traduttore");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        formattedTextField1.setText("ENGLISH->ITALIANO");
        ENGLISHITALIANOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formattedTextField1.setText("ENGLISH->ITALIANO");
                switchino = true;
            }
        });
        ITALIANOENGLISHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formattedTextField1.setText("ITALIANO->ENGLISH");
                switchino = false;
            }
        });
        TRADUCIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parola = originale.getText();
                if(switchino){
                    if(TesterTraduttore.alberinoIng.cercaParola(parola, TesterTraduttore.alberinoIng.getRoot()) == null){
                        traduzione.setText("Sorry, i can't translate this one yet :(");
                        return;
                    }
                    traduzione.setText(TesterTraduttore.alberinoIng.cercaParola(parola, TesterTraduttore.alberinoIng.getRoot()));
                }
                if(!switchino){
                    if(TesterTraduttore.alberinoIta.cercaParola(parola, TesterTraduttore.alberinoIta.getRoot()) == null){
                        traduzione.setText("Mi spiazie, non posso tradurlo :(");
                        return;
                    }
                    traduzione.setText(TesterTraduttore.alberinoIta.cercaParola(parola, TesterTraduttore.alberinoIta.getRoot()));
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originale.setText("");
                traduzione.setText("");
            }
        });
    }
    public static void main(String[] args){
        MainTraduzione traduttorino = new MainTraduzione();
    }
}
