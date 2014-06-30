class board {
	int size;
	int turns = 20;
	int thisturn = 1;
	//Testa se o jogo está acontecendo a qualquer momento (vai ser um aglomerado de ifs)
	boolean isHappening () {
		if (thisturn<=turns) {
			return true;
		}
		else return false;
	}
}