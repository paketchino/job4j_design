package ru.job4j.ood.tictactoe;

import ru.job4j.ood.tictactoe.players.Player;

import java.util.Scanner;

public interface RunGame {

    /**
     * Запускает ссесию
     * @param scanner то что будут вводить игроки
     * @param player1 игрок 1
     * @param player2 игрок 2
     */
    void run(Scanner scanner, Player player1, Player player2);
}
