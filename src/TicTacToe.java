package src;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Winner is: " + game.startGame());
    }
}

class TicTacToeGame {
    Deque<Player> players;
    Board playingBoard;

    TicTacToeGame() {
        initialize();
    }

    public void initialize() {
        players = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("1", cross);
        PlayingPieceO o = new PlayingPieceO();
        Player player2 = new Player("2", o);
        players.add(player1);
        players.add(player2);

        playingBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();
            playingBoard.printBoard();

            List<int[]> freeCell = playingBoard.freeCells();
            if (freeCell.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + playerTurn.name + " Enter row and cols: ");
            Scanner inp = new Scanner(System.in);
            String s = inp.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = playingBoard.addPiece(row, col, playerTurn.playingPiece);
            if (!pieceAddedSuccessfully) {
                System.out.println("Incorrect position please try again: ");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereAWinner(row, col, playerTurn.playingPiece.pieceType);
            if (winner) {
                return playerTurn.name;
            }
        }
        return "TIE";
    }

    public boolean isThereAWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < playingBoard.size; i++) {
            if (playingBoard.board[row][i] == null || playingBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < playingBoard.size; i++) {
            if (playingBoard.board[i][col] == null || playingBoard.board[i][col].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < playingBoard.size; i++, j++) {
            if (playingBoard.board[i][j] == null || playingBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < playingBoard.size; i++, j++) {
            if (playingBoard.board[j][i] == null || playingBoard.board[j][i].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}

enum PieceType {
    X, O;
}

class PlayingPiece {
    PieceType pieceType;

    PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}

class PlayingPieceX extends PlayingPiece {
    PlayingPieceX() {
        super(PieceType.X);
    }
}

class PlayingPieceO extends PlayingPiece {
    PlayingPieceO() {
        super(PieceType.O);
    }
}

class Board {
    public final int size;
    public PlayingPiece[][] board;

    Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] != null) {
            return false;
        }

        board[row][col] = playingPiece;
        return true;
    }

    public List<int[]> freeCells() {
        List<int[]> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new int[]{i, j});
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType + "  |  ");
                } else {
                    System.out.print(" " + "  |  ");
                }
            }
            System.out.println();
        }
    }
}

class Player {
    String name;
    PlayingPiece playingPiece;

    Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }
}