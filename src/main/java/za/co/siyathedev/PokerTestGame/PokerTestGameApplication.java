package za.co.siyathedev.PokerTestGame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.siyathedev.PokerTestGame.game.MyPokerGame;

@SpringBootApplication
public class PokerTestGameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PokerTestGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MyPokerGame myPokerGame = new MyPokerGame();
		myPokerGame.play();
	}
}
