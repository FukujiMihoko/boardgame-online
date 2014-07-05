import java.lang.Math;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class boardgameonlineGUI extends JFrame implements ActionListener {

	//Declara o que será referenciado em métodos
	//Não tem problema ser static, pois é a classe onde o main() se encontra
	static player[] jogador = new player[4];
	static JLabel[] pScore;
	static JButton turnButton;
	static board a;

	//Construtor inicializando objetos
	boardgameonlineGUI () {	
		for (int i=0;i<jogador.length;i++) {
			jogador[i] = new player();
		}
		a = new board();
		/*while (a.isHappening()) {
			System.out.println("Turno "+a.thisturn+"/"+a.turns);
			for(int i=0;i<jogador.length;i++) {
				turno(jogador[i]);
				System.out.println("Posicao do jogador["+i+"] = "+jogador[i].posicao);
			}
			a.thisturn++;
		}*/
	}


	public JPanel createContentPane (){
        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the title labels
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(10, 0);
        titlePanel.setSize(500, 30);
        totalGUI.add(titlePanel);
        
        JLabel[] pLabel = new JLabel[jogador.length];

        for(int i=0;i<pLabel.length;i++) {
        	pLabel[i] = new JLabel("Player "+(i+1));
        	pLabel[i].setLocation(120*i,0);
        	pLabel[i].setSize(100,30);
        	pLabel[i].setHorizontalAlignment(0);
        	switch(i%4) {
        		case 0:
        		pLabel[i].setForeground(Color.red);
        		break;

        		case 1:
        		pLabel[i].setForeground(Color.blue);
        		break;

        		case 2:
        		pLabel[i].setForeground(Color.green);
        		break;

        		case 3:
        		pLabel[i].setForeground(Color.pink);
        		break;
        	}
        	titlePanel.add(pLabel[i]);
        }
        /*
        JLabel p1Label = new JLabel("Player 1");
        p1Label.setLocation(0, 0);
        p1Label.setSize(100, 30);
        p1Label.setHorizontalAlignment(0);
        p1Label.setForeground(Color.red);
        titlePanel.add(p1Label);

        JLabel p2Label = new JLabel("Player 2");
        p2Label.setLocation(120, 0);
        p2Label.setSize(100, 30);
        p2Label.setHorizontalAlignment(0);
        p2Label.setForeground(Color.blue);
        titlePanel.add(p2Label);

        JLabel p3Label = new JLabel("Player 3");
        p3Label.setLocation(240, 0);
        p3Label.setSize(100, 30);
        p3Label.setHorizontalAlignment(0);
        p3Label.setForeground(Color.green);
        titlePanel.add(p3Label);

        JLabel p4Label = new JLabel("Player 4");
        p4Label.setLocation(360, 0);
        p4Label.setSize(100, 30);
        p4Label.setHorizontalAlignment(0);
        p4Label.setForeground(Color.pink);
        titlePanel.add(p4Label);*/

        // Creation of a Panel to contain the score labels.
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(10, 40);
        scorePanel.setSize(500, 30);
        totalGUI.add(scorePanel);

        pScore = new JLabel[jogador.length];
        for(int i=0;i<jogador.length;i++) {
        	pScore[i] = new JLabel("0");
        	pScore[i].setLocation(120*i,0);
        	pScore[i].setSize(100,30);
        	pScore[i].setHorizontalAlignment(0);
        	scorePanel.add(pScore[i]);
        }

        /*JLabel p1Score = new JLabel("0");
        p1Score.setLocation(0, 0);
        p1Score.setSize(100, 30);
        p1Score.setHorizontalAlignment(0);
        scorePanel.add(p1Score);

        JLabel p2Score = new JLabel("0");
        p2Score.setLocation(120, 0);
        p2Score.setSize(100, 30);
        p2Score.setHorizontalAlignment(0);
        scorePanel.add(p2Score);

        JLabel p3Score = new JLabel("0");
        p3Score.setLocation(240, 0);
        p3Score.setSize(100, 30);
        p3Score.setHorizontalAlignment(0);
        scorePanel.add(p3Score);

        JLabel p4Score = new JLabel("0");
        p4Score.setLocation(360, 0);
        p4Score.setSize(100, 30);
        p4Score.setHorizontalAlignment(0);
        scorePanel.add(p4Score);*/

        // Creation of a label to contain all the JButtons.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 80);
        buttonPanel.setSize(500, 70);
        totalGUI.add(buttonPanel);

        // We create a button and manipulate it using the syntax we have
        // used before.
        JButton p1Button = new JButton("Player 1!");
        p1Button.setLocation(0, 0);
        p1Button.setSize(100, 30);
        buttonPanel.add(p1Button);

        JButton p2Button = new JButton("Player 2!");
        p2Button.setLocation(120, 0);
        p2Button.setSize(100, 30);
        buttonPanel.add(p2Button);

        JButton p3Button = new JButton("Player 3!");
        p3Button.setLocation(240, 0);
        p3Button.setSize(100, 30);
        buttonPanel.add(p3Button);

        JButton p4Button = new JButton("Player 4!");
        p4Button.setLocation(360, 0);
        p4Button.setSize(100, 30);
        buttonPanel.add(p4Button);

        turnButton = new JButton("New Turn");
        turnButton.setLocation(0, 40);
        turnButton.setSize(460, 30);
        turnButton.addActionListener(this);
        System.out.println("teste");
        buttonPanel.add(turnButton); 
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JButton Scores! [=]");

        //Create and set up the content pane.
        boardgameonlineGUI demo = new boardgameonlineGUI();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 190);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

	/*public static void main (String[] args) throws IOException {	
		//throws IOException pro BufferedInputStream de baixo rodar (DEM THROWS)
		player[] jogador = new player[4];
		for (int i=0;i<jogador.length;i++) {
			jogador[i] = new player();
		}
		board a = new board();
		Scanner sc = new Scanner(System.in);
		//Enquanto o jogo está rodando, roda a rotina padrão de um turno (exceções serão tratadas em turno())
		//ButtonDemo gui = new ButtonDemo();
		//gui.main(args);
		while (a.isHappening()) {
			System.out.println("Turno "+a.thisturn+"/"+a.turns);
			for(int i=0;i<jogador.length;i++) {
				turno(jogador[i]);
				System.out.println("Posicao do jogador["+i+"] = "+jogador[i].posicao);
			}
			a.thisturn++;
			//Faz esperar um enter ;)
			sc.nextLine();
		}
	}*/

	//Faz o turno acontecer, e um evento no final
	void turno (player jogador, int ordem) {
		eventos event = new eventos();
		if (!jogador.skip) {
			int dado1 = (int)(Math.random()*6)+1;
			wait(1);
			int dado2 = (int)(Math.random()*6)+1;
			wait(1);
			int dado=dado1+dado2;
			System.out.println("Dado do jogador "+(ordem+1)+" = "+dado);
			jogador.anda(dado+jogador.speed);
			event.jogador = jogador;
			event.gera();
		} else jogador.skip = false;
		String skip;
		if (jogador.skip) {
			skip=" Skip";
		} else skip="";
		pScore[ordem].setText(""+jogador.posicao+skip);
		setVisible(true);
	}

	public void actionPerformed (ActionEvent event) {
		Object source = event.getSource();
		if (source == this.turnButton) {
			setVisible(true);
			for(int i=0; i<jogador.length;i++) {
				turno(jogador[i],i);
			}
			a.thisturn++;
		}
	}

	//Método pra esperar n milisegundos (corrigir o random)
	public static void wait (int n){
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while (t1 - t0 < n);
	}
}