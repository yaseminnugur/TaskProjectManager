package management.model;

import java.time.LocalDate;

/**
 * Görevlerin son teslim tarihlerini (deadline) yönetmek için kullanılan sınıftır.
 * Java'nın modern tarih API'si olan {@link LocalDate} yapısını kullanarak
 * tarih bazlı kontrollerin yapılmasına olanak sağlar.
 * * @author Yasemin
 * @version 1.0
 */
public class Deadline {

    /** Görevin tamamlanması gereken son tarih değeri */
    private LocalDate dueDate;

    /**
     * Belirlenen bir tarih ile yeni bir Deadline nesnesi oluşturur.
     * * @param dueDate Görevin son teslim tarihi (LocalDate tipinde)
     */
    public Deadline(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Görevin son teslim tarihini döndürür.
     * * @return {@link LocalDate} olarak vadedilen tarih
     */
    public LocalDate getDueDate() {
        return dueDate;
    }
}