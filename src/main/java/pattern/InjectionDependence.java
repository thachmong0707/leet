package pattern;

public class InjectionDependence {

    public static void main(String[] args) {
        new InjectionDependence().main11(args);
    }

    public void main11(String[] args) {
        MessageService messageService = new EmailService();
        UserController userController = new UserController(messageService);
        userController.send();
    }

    public class UserController {

        private MessageService messageService;

        public UserController(MessageService messageService) {
            this.messageService = messageService;
        }

        public void send() {
            messageService.sendMessage("Hello Dependency injection pattern");
        }
    }

    public class SmsService implements MessageService {

        @Override
        public void sendMessage(String message) {
            System.out.println("Sms message: " + message);
        }
    }


    public class EmailService implements MessageService {

        @Override
        public void sendMessage(String message) {
            System.out.println("Email message: " + message);
        }
    }

    public interface MessageService {

        void sendMessage(String message);
    }
}

