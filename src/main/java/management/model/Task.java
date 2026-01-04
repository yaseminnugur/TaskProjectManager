package management.model;

/**
 * Sistemdeki her bir iş birimini temsil eden temel görev sınıfıdır.
 * Bu sınıf, bir görevin başlığını, açıklamasını, öncelik durumunu ve
 * tamamlanma bilgisini tutar.
 * * @author Yasemin
 * @version 1.0
 */
public class Task implements Completable {

    /** Görevin kısa başlığı */
    private String title;

    /** Görevin detaylı açıklaması */
    private String description;

    /** Görevin tamamlanıp tamamlanmadığı bilgisi */
    private boolean completed;

    /** Görevin öncelik seviyesi (LOW, MEDIUM, HIGH) */
    private Priority priority;

    /**
     * Yeni bir Task nesnesi oluşturur. Başlangıçta görev tamamlanmamış olarak işaretlenir.
     * * @param title Görevin başlığı
     * @param description Görevin detaylı açıklaması
     * @param priority Görevin öncelik derecesi
     */
    public Task(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    /**
     * Görevin başlığını döndürür.
     * @return Görev başlığı
     */
    public String getTitle() {
        return title;
    }

    /**
     * Görevin öncelik durumunu döndürür.
     * @return {@link Priority} tipinde öncelik değeri
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Görevin detaylı açıklamasını döndürür.
     * @return Görev açıklaması
     */
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     * Görevi "tamamlandı" durumuna getirir.
     */
    @Override
    public void complete() {
        this.completed = true;
    }

    /**
     * {@inheritDoc}
     * Görevin mevcut tamamlanma durumunu kontrol eder.
     * @return Tamamlanmışsa true, aksi halde false
     */
    @Override
    public boolean isCompleted() {
        return completed;
    }
}