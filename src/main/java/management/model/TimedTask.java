package management.model;

/**
 * Belirli bir teslim tarihine (deadline) sahip olan görevleri temsil eden sınıftır.
 * {@link Task} sınıfından türetilmiştir ve temel görev özelliklerine ek olarak
 * zaman yönetimi imkanı sunar.
 * * @author Yasemin
 * @version 1.0
 */
public class TimedTask extends Task {

    /** Görevin atanmış olan son teslim tarihi */
    private Deadline deadline;

    /**
     * Yeni bir süreli görev nesnesi oluşturur.
     * * @param title Görevin başlığı
     * @param description Görevin detaylı açıklaması
     * @param priority Görevin öncelik derecesi
     * @param deadline Görevin vadesini belirten {@link Deadline} nesnesi
     */
    public TimedTask(String title, String description, Priority priority, Deadline deadline) {
        super(title, description, priority);
        this.deadline = deadline;
    }

    /**
     * Görevin son teslim tarihini döndürür.
     * * @return Göreve ait {@link Deadline} nesnesi
     */
    public Deadline getDeadline() {
        return deadline;
    }
}