package management.model;

/**
 * Bu arayüz, bir nesnenin tamamlanabilir olma durumunu temsil eder.
 * Proje içindeki görevlerin (Task, TimedTask vb.) tamamlanma durumlarını
 * yönetmek için ortak bir sözleşme sağlar.
 * * @author Yasemin
 * @version 1.0
 */
public interface Completable {

    /**
     * Mevcut nesnenin durumunu "tamamlandı" (completed) olarak işaretler.
     * Bu metot çağrıldıktan sonra {@link #isCompleted()} metodunun
     * true dönmesi beklenir.
     */
    void complete();

    /**
     * Nesnenin tamamlanıp tamamlanmadığı bilgisini döner.
     * * @return Nesne tamamlanmışsa true, aksi takdirde false döner.
     */
    boolean isCompleted();
}