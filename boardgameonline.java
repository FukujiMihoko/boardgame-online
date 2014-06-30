import java.lang.Math;
import java.io.*;

class boardgameonline{
	public static void main (String[] args) throws IOException {	
		//throws IOException pro BufferedInputStream de baixo rodar (DEM THROWS)
		player[] jogador = new player[4];
		for (int i=0;i<jogador.length;i++) {
			jogador[i] = new player();
		}
		board a = new board();
		//Enquanto o jogo está rodando, roda a rotina padrão de um turno (exceções serão tratadas em turno())
		while (a.isHappening()) {
			System.out.println("Turno "+a.thisturn+"/"+a.turns);
			for(int i=0;i<jogador.length;i++) {
				turno(jogador[i]);
				System.out.println("Posicao do jogador["+i+"] = "+jogador[i].posicao);
			}
			a.thisturn++;
			//Faz esperar um enter ;)
			//NÃO SEI O QUE MAIS ESSA PORRA FAZ BTW
			BufferedInputStream reader = new BufferedInputStream(System.in);
			reader.read();
		}
	}

	//Faz o turno acontecer, e um evento no final
	static void turno (player jogador) {
		eventos event = new eventos();
		if (!jogador.skip) {
			int dado1 = (int)(Math.random()*6)+1;
			wait(1);
			int dado2 = (int)(Math.random()*6)+1;
			wait(1);
			int dado=dado1+dado2;
			System.out.println("Dado = "+dado);
			jogador.anda(dado+jogador.speed);
			event.jogador = jogador;
			event.gera();
		} else jogador.skip = false;
	}

	//Método pra esperar n milisegundos (corrigir o random)
	public static void wait (int n){
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		}
		while (t1 - t0 < n);
	}
}