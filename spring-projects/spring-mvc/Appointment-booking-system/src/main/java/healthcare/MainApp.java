
package healthcare;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the service bean
        AppointmentService service = (AppointmentService) context.getBean("appointmentService");

        // Call the method
        String result = service.book("DOC101", "2025-04-10");
        System.out.println(result);  // Output: Appointment confirmed

        String result2 = service.book("DOC101", "2025-04-20");
        System.out.println(result2);  // Output: Doctor not available
    }
}
