package com.main.example;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.airline.service.TicketService;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("airline-context.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");

        System.out.println(ticketService.confirmBooking("FL123", "USER456"));
        System.out.println(ticketService.confirmBooking("FL999", "USER789"));
    }
}
