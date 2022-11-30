public class Main {
    public static void main(String[] args) {
        String operation = args[0];
        String parameter = args[1];

        //System.out.println(MagicSquare.toString(MagicSquare.toSquare(parameter)));

        switch (operation) {
            case "showMagicNumbers":
                System.out.println(MagicSquare.showMagicNumbers(Integer.parseInt(parameter)));
                break;
            case "complement":
                System.out.println(MagicSquare.toString(MagicSquare.complement(parameter)));
                break;
            case "isMagicSquare":
                if (MagicSquare.isMagicSquare(parameter)) {
                    System.out.println("magic square");
                } else {
                    if (MagicSquare.isSemimagicSquare(parameter)) {
                        System.out.println("semimagic square");
                    } else {
                        System.out.println("not magical");
                    }
                    break;
                }

        }
    }
}
