package com.scalar.alok.oops.ttt.model;

import com.scalar.alok.oops.ttt.exceptions.DuplicateSymbolFoundException;
import com.scalar.alok.oops.ttt.exceptions.InvalidBotCountPlayer;
import com.scalar.alok.oops.ttt.exceptions.InvalidMoveException;
import com.scalar.alok.oops.ttt.exceptions.InvalidPlayerCountException;
import com.scalar.alok.oops.ttt.strategies.GameWinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategies> winningStrategies;
    private Game(GameBuilder gameBuilder) {
        this.board = new Board(gameBuilder.diamention);
        this.players = gameBuilder.players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = gameBuilder.winningStrategies;
    }
    public void makeMove(Game game) throws  InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("This is the "+ currentPlayer.getName() + "s' turn.");
        Move currentMove = currentPlayer.move(board);
        //validate the
        if(!isValidateMove(currentMove))
        {
            throw  new InvalidMoveException("The current move is invalid move.");
        }
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getColumn();

        Cell marked = board.getCells().get(row).get(col);
        marked.setCellState(CellState.FILLED);
        marked.setPlayer(currentPlayer);

        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
        Move nextMove = new Move(marked, currentPlayer);
        moves.add(nextMove);
        if(checkWinner(nextMove, currentPlayer))
        {
            gameState = GameState.ENDED;
            game.winner = currentPlayer;
        }
        else if(moves.size() == board.getSize() * board.getSize()){

            gameState = GameState.DRAW;
        }
    }
    public void printBoard()
    {
        board.printBoard();
    }


    private boolean checkWinner(Move move, Player currentPlayer)
    {
        for(WinningStrategies strategy : winningStrategies){
            if(strategy.checkWinner(board, move))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isValidateMove(Move move)
    {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        if(row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize() &&
                board.getCells().get(row).get(col).getCellState() == CellState.EMPTY)
        {
               return true;
        }
        return false;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public static GameBuilder newBuilder() {
        return new GameBuilder();
    }

    public static class GameBuilder
    {
        private int  diamention;
        private List<Player> players;

        private List<WinningStrategies> winningStrategies;
        public GameBuilder sedimentation(int d ) {
            this.diamention = d;
            return this;
        }


        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }


        public Game build() throws DuplicateSymbolFoundException, InvalidPlayerCountException, InvalidBotCountPlayer {
            validate();
            return new Game(this);
        }


        //private methods
        private void validate() throws DuplicateSymbolFoundException, InvalidPlayerCountException, InvalidBotCountPlayer
        {
            validateNo2PlayersHaveSameMethods();
            validatesPlayerCount();
            validateNumberOfBotPlayer();
        }
        private void validateNo2PlayersHaveSameMethods() throws  DuplicateSymbolFoundException
        {
            Map<Character, Integer> symbols = new HashMap<>();
            for (Player player : players) {
                Character playerSymbol  = player.getSymbol().getSymbol();
                if(!symbols.containsKey(playerSymbol))
                {
                    symbols.put(playerSymbol, 1);
                }
                else {
                    throw  new DuplicateSymbolFoundException("Two players should not have same symbols");
                }
            }
        }
        private void validatesPlayerCount() throws  InvalidPlayerCountException
        {
            if(players.size() != diamention - 1)
            {
                throw  new InvalidPlayerCountException("Number of players should be: " + (diamention - 1));
            }
        }

        private void validateNumberOfBotPlayer() throws InvalidBotCountPlayer
        {
            int boatPlayerCount = 0;
            for (Player player : players) {
                if(player.getPlayerType() == PlayerType.BOT )
                {
                    boatPlayerCount++;
                }
                if(boatPlayerCount > 1)
                {
                    throw  new InvalidBotCountPlayer("only one bot player allowed per game");
                }
            }
        }
    }
}
