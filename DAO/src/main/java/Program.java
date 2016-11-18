import factories.UserServiceFactory;
import model.User;
import service.UserService;

public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007");
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008");
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009");
//        UsersDao usersDao = new UsersDaoArrayListImpl();
//        UsersDao usersDao = new UsersDaoFileImpl();

//        UsersDao usersDao = DaoFactory.getInstance().getDao();
//        Verifier verifier = new VerifierImpl();
        UserService userService = UserServiceFactory.getInstance().getUserService();
        userService.addUser(marsel);
        userService.addUser(nastya);
        userService.addUser(ilya);
//        UserService userService = new UserServiceImpl(usersDao, verifier);
        if (userService.isRegistered("Ilya")) {
            System.out.println("Ilya is Registered");
        } else {
            System.out.println("not registered");
        }

        for (User currentUser : userService.findAll()) {
            System.out.println(currentUser);
        }
        userService.removeUser(1);
        for (User currentUser : userService.findAll()) {
            System.out.println(currentUser);
        }
    }
}
