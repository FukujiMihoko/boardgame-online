class player {
	int posicao;
	int speed;
	boolean skip = false;
	boolean dead = false;
	void anda (int i) {
		posicao += i;
	}
}