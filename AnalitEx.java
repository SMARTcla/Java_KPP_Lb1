public class AnalitEx {
    public  static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        boolean exit = false;
        String func;
        double from, to, step;
        int choice;
        while (!exit) {
            System.out.println("\n1. Функция с параметром");
            System.out.println("2. Функция без параметра");
            System.out.println("3. Выход");
            choice = scanInteger();
            switch (choice) {
                case 1:
                    System.out.println("Введите нужную функцию: ");
                    func = scanLine();
                    do{
                        System.out.println("От:");
                        from = scanDouble();
                        System.out.println("До:");
                        to = scanDouble();
                    } while (from >= to);
                    System.out.println("Шаг: ");
                    step = scanDouble();
                    withParam(func, from, to, step);
                break;
                case 2:
                    System.out.println("Введите нужную функцию: ");
                    func = scanLine();
                    do{
                        System.out.println("От:");
                        from = scanDouble();
                        System.out.println("До:");
                        to = scanDouble();
                    } while (from >= to);
                    System.out.println("Шаг: ");
                    step = scanDouble();
                    withoutParam(func, from, to, step);
                break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
    public static void withParam(String funStr, double from, double to, double step) {
        Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);
        System.out.println("1. Функция с параметром");
        Variable par = new Variable("a");
        Variable var = new Variable("x");
        parser.add(var);
        parser.add(par);
        Expression fun = parser.parse(funStr);
        Expression der = fun.derivative(var);
        System.out.println("f(x) = " + fun.toString());
        System.out.println("f'(x) = " + der.toString());
        par.setVal(1.0);
        for (double x = from; x <= to; x += step) {
            var.setVal(x);
            System.out.println(x + "\t" + fun.getVal() + "\t" + der.getVal());
        }
    }
    public static void withoutParam(String funStr, double from, double to, double step) {
        Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);
        System.out.println("2. Функция без параметра");
        Variable var = new Variable("x");
        parser.add(var);
        var funs = parser.parse(funStr);
        Expression ders = funs.derivative(var);
        System.out.println("f(x) = " + funs.toString());
        System.out.println("f'(x) = " + ders.toString());
        for (double x = from; x <= to; x += step) {
            var.setVal(x);
            System.out.println(x + "\t" + funs.getVal() + "\t" + ders.getVal());
        }
    }
    public static int scanInteger(){
        int num = 0;
        boolean check = true;
        while (check){
            check = false;
            try {
                num = Integer.parseInt(in.readLine());
            } catch (NumberFormatException | IOException e){
                check = true;
                System.err.println("Incorrect number format");
            }
        }
        return num;
    }
    public static double scanDouble(){
        double num = 0;
        boolean check = true;
        while (check){
            check = false;
            try {
                num = Double.parseDouble(in.readLine());
            } catch (NumberFormatException | IOException e){
                check = true;
                System.err.println("Incorrect number format");
            }
        }
        return num;
    }
    public static String scanLine(){
        String check = "";
        try {
            check = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }
}
