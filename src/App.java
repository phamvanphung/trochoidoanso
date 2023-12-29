import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {

    private static Random random = new Random();
    private static Map<String, Game> hashmapGame = new HashMap<>();


    public static Game game(Scanner scanner, int max, int min, Player player, Game game){

        int guess = 0;
        int mark = game.getMark();
        int level = game.getLevel();
        int times = 0;
        int timesSystem = 4;

        guess = random.nextInt(max)+min;
        while (times < timesSystem ){
            System.out.println("Vui long nhap so doan: ");
            int soNhapVao = scanner.nextInt();

            if(soNhapVao > guess) {
                System.out.println("Lon hon!");
                times++;
            } else if (soNhapVao < guess) {
                System.out.println("Nho hon!");
                times++;

            } else {
                level = level + 1;
                mark = mark + 20;
                System.out.println("Bang roi.");
                game.setLevel(level);
                game.setMark(mark);
                game.setPlayer(player);
                return game;
            }
        }
        if(times >= timesSystem) {
            System.out.println("Qua so lan doan. Vui long choi luot moi!");
            return null;
        }
        return null;

    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gg = 2;
        while (gg == 2) {
            System.out.println("Vui long chon:");
            System.out.println("1. Choi");
            System.out.println("2. Xem Danh Sach Diem");
            System.out.println("3. Tim Kiem Ket Qua Theo Email");
            System.out.println("4. Thoat tro choi");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                {

                    int max = 100;
                    int min = 1;

                    // choi
                    System.out.println("Vui long nhap ten: ");
                    String name = scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.println("Vui long nhap email: ");
                    String email = scanner.nextLine();

                    Player player = new Player(name, email);
                    // choi
                    int continueGame = 1;
                    Game game = new Game();;
                    while (continueGame == 1) {
                        game = game(scanner, max, min, player, game);
                        System.out.println("Co muon choi tiep hong:");
                        System.out.println("1. Co:");
                        System.out.println("2. Khong:");
                        continueGame = scanner.nextInt();
                        if(continueGame == 2) {
                            break;
                        }
                    }

                    if(game.equals(null)) {
                        System.out.println("Qua so lan");
                    } else {
                        // luu hash map
                        System.out.println("Level: " + game.getLevel());
                        System.out.println("Name: " + game.getPlayer().getName());
                        System.out.println("Email: " + game.getPlayer().getEmail());
                        System.out.println("Mark: " + game.getMark());
                        System.out.println("He Thong Da Luu Lai");
                        hashmapGame.put(email, game);
                        System.out.println("Thoat chuong trinh");

                    }
                    break;
                }
                case 2:
                {
                    System.out.println("----------------------------------------------------");
                    System.out.println("|Name       | Email        | Level        | Mark  |");
                    for (Game game : hashmapGame.values()){
                        System.out.print(game.getPlayer().getName() + "     " );
                        System.out.print(game.getPlayer().getEmail() + "     " );
                        System.out.print(game.getLevel() + "     " );
                        System.out.print(game.getMark() + "     " );
                        System.out.print("\n");

                    }
                }
                case 3:
                {
                    System.out.println("Vui long nhap email:");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    if(email.isBlank()){
                        System.out.println("Ban chua nhap email, Vui long nhap lai email");
                        break;
                    }
                    try {
                        Game game = hashmapGame.get(email);
                        System.out.println("Ket qua:");
                        System.out.println("Name: " + game.getPlayer().getName());
                        System.out.println("Email: " + game.getPlayer().getEmail());
                        System.out.println("Level: " + game.getLevel());
                        System.out.println("Mark: " + game.getMark());
                        break;
                    } catch (Exception e){
                        System.out.println("Khong tim thay lich su choi!");
                        break;
                    }

                }
                case 4:
                {
                    System.out.println("Ban Da Chon Thoat Tro Choi!");
                    gg = 1;
                    break;
                }
                default:
                    System.out.println("Chon sai roi!");
                    break;

            }

        }

    }

}
