package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.blackjack.player.BasicPlayer;
import com.blackjack.player.Player;

public class Game {

	private List<Player> players = new ArrayList<>();
	private Deck deck = new Deck();
	private int numPlayers;
	
	private double minBet = 5;
	private double maxBet = 100;
	private double pot;
	
	public static void main(String[] args) {
		Game game = new Game(5);
		game.createPlayers();
		for (int i = 0; i < 100; i++) {
			game.playRound();
		}
	}
	
	public Game(int numPlayers) {
		super();
		this.numPlayers = numPlayers;
	}
	
	private void playRound() {
		System.out.println("=== Dealing cards ===");
		deal();
		showGameState();
		System.out.println("=== Players draw cards ===");
		for (Player player : players) {
			player.play(deck);
		}
		List<Player> winners = calculateWinners();
		distributeWinnings(winners);
		pot = 0;
		System.out.println("=== End game state ===");
		showGameState();
		clearHands();
	}

	private void distributeWinnings(List<Player> winners) {
		List<String> winnerNames = winners.stream().map(p -> p.getName()).collect(Collectors.toList());
		System.out.println("Winners are " + winnerNames);
		double earnings = pot / (double) winners.size();
		for (Player winner : winners) {
			winner.addWinnings(earnings);
		}
	}

	private void showGameState() {
		for (Player player : players) {
			System.out.println(player.getState());
		}
	}
	
	private List<Player> calculateWinners() {
		// filter out any player who has busted
		List<Player> playersInGame = players.stream().filter(p -> !p.busts()).collect(Collectors.toList());
		if (playersInGame.isEmpty()) {
			return new ArrayList<>();
		}
		// the best hand is the highest score of players who haven't busted
		int bestHand = Collections.max(playersInGame.stream().map(p -> p.getFinalPoints()).collect(Collectors.toList()));
		// anyone who has this score wins the game
		return players.stream().filter(p -> p.getFinalPoints() == bestHand).collect(Collectors.toList());
	}
	
	private void createPlayers() {		
		for (int i = 1; i <= numPlayers; i++) {
			players.add(new BasicPlayer("Player " + i));
		}
	}

	private void clearHands() {
		List<Player> bankruptPlayers = new ArrayList<>();
		for (Player player : players) {
			player.getHand().clear();
			if (player.getFunds() <= 0) {
				bankruptPlayers.add(player);
			}
		}
		players.removeAll(bankruptPlayers);
	}
	
	private void deal() {
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.draw(deck);
				pot += player.placeBet(this);
			}
		}		
	}

	public double getMinBet() {
		return minBet;
	}

	public double getMaxBet() {
		return maxBet;
	}
	
}
