package management;

import management.model.*;
import management.util.FileExporter;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Görev Yönetim Sistemi'nin ana giriş sınıfıdır.
 * Bu sınıf, kullanıcı arayüzünü (CLI) yönetir, kullanıcıdan girdileri alır
 * ve ilgili iş mantığı servislerini yönlendirir.
 * * @author Yasemin
 * @version 1.0
 */
public class Main {

    /** Kullanıcıdan veri almak için kullanılan paylaşımlı Scanner nesnesi */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Programın ana döngüsünün çalıştığı giriş metodudur.
     * Proje nesnesini başlatır ve kullanıcı çıkış yapana kadar menüyü görüntüler.
     * * @param args Komut satırı argümanları (kullanılmamaktadır)
     */
    public static void main(String[] args) {

        Project project = new Project("OOP Görev Yönetim Sistemi");
        Notification notification = new Notification();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addTask(project);
                case 2 -> completeTask(project);
                case 3 -> listUpcomingTasks(project);
                case 4 -> notification.notifyUpcomingTasks(project, 3);
                case 5 -> FileExporter.exportProject(project, "project_output.txt");
                case 0 -> {
                    System.out.println("Programdan çıkılıyor...");
                    running = false;
                }
                default -> System.out.println("Geçersiz seçim!");
            }
        }
    }

    // ---------------- MENU ----------------

    /**
     * Kullanıcıya sunulan ana menü seçeneklerini konsola yazdırır.
     */
    private static void printMenu() {
        System.out.println("\n--- GÖREV YÖNETİM SİSTEMİ ---");
        System.out.println("1 - Görev ekle");
        System.out.println("2 - Görev tamamla");
        System.out.println("3 - Yaklaşan görevleri listele");
        System.out.println("4 - Hatırlatma göster");
        System.out.println("5 - Dosyaya aktar");
        System.out.println("0 - Çıkış");
        System.out.print("Seçiminiz: ");
    }

    // ---------------- FEATURES ----------------

    /**
     * Kullanıcıdan görev detaylarını alarak projeye yeni bir {@link TimedTask} ekler.
     * * @param project Görevin ekleneceği hedef proje
     */
    private static void addTask(Project project) {
        System.out.print("Görev adı: ");
        String title = sc.nextLine();

        System.out.print("Görev açıklaması: ");
        String description = sc.nextLine();

        System.out.print("Öncelik (LOW, MEDIUM, HIGH, URGENT): ");
        Priority priority = Priority.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Deadline (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        Deadline deadline = new Deadline(date);
        Task task = new TimedTask(title, description, priority, deadline);

        project.addTask(task);
        System.out.println("Görev başarıyla eklendi.");
    }

    /**
     * Belirli bir görevin başlığını kullanıcıdan alarak tamamlanması için
     * {@link Project#completeTask(String)} metoduna yönlendirir.
     * * @param project İşlemin yapılacağı proje nesnesi
     */
    private static void completeTask(Project project) {
        System.out.print("Tamamlanacak görev adı: ");
        String title = sc.nextLine();

        project.completeTask(title);
        System.out.println("Görev tamamlandı (bulunduysa).");
    }

    /**
     * Belirli bir zaman dilimi içindeki yaklaşan görevleri kullanıcıdan alınan
     * gün sayısına göre listeler.
     * * @param project Listenin çekileceği proje nesnesi
     */
    private static void listUpcomingTasks(Project project) {
        System.out.print("Kaç gün içindeki görevler listelensin? ");
        int days = Integer.parseInt(sc.nextLine());

        if (project.getUpcomingTasks(days).isEmpty()) {
            System.out.println("Yaklaşan görev yok.");
            return;
        }

        System.out.println("Yaklaşan görevler:");
        for (TimedTask task : project.getUpcomingTasks(days)) {
            System.out.println(
                    "- " + task.getTitle() +
                            " | Deadline: " + task.getDeadline().getDueDate() +
                            " | Priority: " + task.getPriority()
            );
        }
    }
}