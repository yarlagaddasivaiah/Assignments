package healthcare;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppointmentService appointmentService = context.getBean(AppointmentService.class);

        String result1 = appointmentService.book("DOC101", "2025-04-10");
        System.out.println(result1);  // Output: Appointment confirmed

        String result2 = appointmentService.book("DOC101", "2025-04-15");
        System.out.println(result2);  // Output: Doctor not available
    }
}
