public class Main {
    public static void main(String[] args) {
        String operation = "complement";
        String parameter = "<4-9-2><3-5-7><8-1-6>";

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
