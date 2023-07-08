import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin", "pass", "qwe@qwe.qw", "81234567890", "Иван", "Иванович", "Петров"));
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("апельсин", 300.0));
        products.add(new Product("абрикос", 200.0));
        products.add(new Product("яблоко", 150.0));
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("admin", "pass"));


        while (true) {
            System.out.println("1 - авторизоваться\n2 - зарегистрироваться\n");
            switch (in.nextLine()) {
                case "1":
                    System.out.println("Авторизация");
                    System.out.println("Введите логин");
                    String loginAuth = in.nextLine();
                    System.out.println("Введите пароль");
                    String passAuth = in.nextLine();
                    if (!findUser(loginAuth, passAuth, users)) {
                        System.out.println("Данные не корректны");
                    }

                    if (admUser(loginAuth, passAuth, admins)) {
                        System.out.println("1) Добавление товара\n2) Удаление товара\n3) Просмотр информации о пользователях\n4) Смена роли пользователю\n5) Вернуться в основное меню");
                        boolean stop;
                        do {
                            stop = true;
                            switch (in.nextLine()) {
                                case "1":
                                    Product product = new Product();
                                    System.out.println("Добавить товар");
                                    for (Product pr : products) {
                                        System.out.println(pr);
                                    }
                                    System.out.println("Введите название");
                                    product.setName(in.nextLine());
                                    System.out.println("Введите цену");
                                    product.setPrice(in.nextDouble());
                                    in.nextLine();
                                    products.add(product);
                                    for (Product pr : products) {
                                        System.out.println(pr);
                                    }
                                    break;
                                case "2":
                                    System.out.println("Удалить товар");
                                    for (Product pr : products) {
                                        System.out.println(pr);
                                    }
                                    System.out.println("Введите номер");
                                    products.remove(in.nextInt());
                                    in.nextLine();
                                    for (Product pr : products) {
                                        System.out.println(pr);
                                    }
                                    break;
                                case "3":
                                    System.out.println("Просмотр пользователей");
                                    for (User us : users) {
                                        System.out.println(us);
                                    }
                                    break;
                                case "4":
                                    System.out.println("Смена роли пользователю");
                                    System.out.println("1) Добавить администратора\n2) Удалить администратора\n3) Выйти");
                                    boolean st;
                                    do {
                                        st = true;
                                        switch (in.nextLine()) {
                                            case "1":
                                                System.out.println("Добавление администратора");
                                                System.out.println("Введите логин пользователя");
                                                String login = in.nextLine();
                                                System.out.println("Введите пароль пользователя");
                                                String pass = in.nextLine();
                                                admins.add(new Admin(login, pass));
                                                for (Admin adm : admins) {
                                                    System.out.println(adm);
                                                }
                                                break;
                                            case "2":
                                                System.out.println("Удаление администратора");
                                                System.out.println("Введите номер");
                                                admins.remove(in.nextInt());
                                                in.nextLine();
                                                for (Admin adm : admins) {
                                                    System.out.println(adm);
                                                }
                                                break;
                                            default:
                                                st = false;
                                        }
                                    } while (st);

                                    break;
                                default:
                                    stop = false;
                            }
                        } while (stop);


                    } else {
                        System.out.println("Просмотр доступных товаров для покупки");
                        for (Product pr : products) {
                            System.out.println(pr);
                        }
                    }
                    break;
                case "2":
                    User user = new User();
                    System.out.println("Регистрация");
                    System.out.println("Введите логин");
                    while (!user.setLogin(in.nextLine())) ;
                    System.out.println("Введите пароль");
                    while (!user.setPass(in.nextLine())) ;
                    System.out.println("Введите email");
                    while (!user.setEmail(in.nextLine())) ;
                    System.out.println("Введите телефон");
                    while (!user.setTelephone(in.nextLine())) ;
                    System.out.println("Введите имя");
                    user.setFname(in.nextLine());
                    System.out.println("Введите отчество");
                    user.setPatronymic(in.nextLine());
                    System.out.println("Введите фамилию");
                    user.setSname(in.nextLine());
                    users.add(user);

                    break;
            }
        }
    }

    static boolean findUser(String login, String pass, ArrayList<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPass().equals(pass)) {
                System.out.println("Вы авторизованы");
                return true;
            }
        }
        return false;
    }


    static boolean admUser(String login, String pass, ArrayList<Admin> admins) {
        for (Admin admin : admins) {
            if (admin.getLogin().equals(login) && admin.getPass().equals(pass)) {
                System.out.println("Вы в системе");
                return true;
            }
        }
        return false;
    }


}


