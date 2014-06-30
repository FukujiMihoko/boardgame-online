import java.lang.Math;

class eventos {
	player jogador;
	void gera() {
		int i = (int)(Math.random()*5);
		acontece(i);
	}
	//Eventos vão existir aqui
	void acontece(int i) {
		switch (i) {
			case 1:
				jogador.skip = true;
				System.out.println("Jogador perdeu o turno");
				break;
			case 2:
				int j = (int)(Math.random()*5)*-1;
				jogador.anda(j);
				System.out.println("Voltou "+j);
				break;
			default:
				break;
		}
	}
}