import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Entre com nome do departamento: ");
        String nomeDepartamento = sc.nextLine();
        System.out.println("Entre com dos dados do trabalhador");
        System.out.print("Name: ");
        String nomeTrabalhador = sc.nextLine();
        System.out.print("Level: ");
        String levelTrabalhador = sc.nextLine();
        System.out.print("Salário: ");
        double salarioTrabalhador = sc.nextDouble();
        Worker worker = new Worker(nomeTrabalhador, WorkerLevel.valueOf(levelTrabalhador), salarioTrabalhador, new Department(nomeDepartamento));
        
        System.out.print("Quantos contratos esse trabalhador tem?");
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            System.out.println("Entre com o número do contrato #" + i + " data:");
            System.out.print("Data (DD/MM/YY): ");
            LocalDate contractDate = LocalDate.parse(sc.next(), fmt1);
            System.out.print("valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração (hora): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Entre com o mês e ano que deseja caucular o ganho (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Ganho em " + monthAndYear + " de: " + String.format("%.2f", worker.icome(year, month)));
        sc.close();
    }
}
