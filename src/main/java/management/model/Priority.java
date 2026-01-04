package management.model;

/**
 * Görevlerin önem derecelerini belirlemek için kullanılan öncelik seviyeleridir.
 * Bu enum yapısı, görevlerin filtrelenmesi ve sıralanması işlemlerinde
 * standart bir değer kümesi sağlar.
 * * @author Yasemin
 * @version 1.0
 */
public enum Priority {
    /** Düşük öncelikli görevler */
    LOW,

    /** Orta öncelikli görevler */
    MEDIUM,

    /** Yüksek öncelikli görevler */
    HIGH,

    /** Acil müdahale gerektiren, en yüksek öncelikli görevler */
    URGENT
}