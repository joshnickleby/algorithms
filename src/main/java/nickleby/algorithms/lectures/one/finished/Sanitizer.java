package nickleby.algorithms.lectures.one.finished;

import java.util.Objects;
import java.util.UUID;

public abstract class Sanitizer {

    private UUID id;

    protected Sanitizer(UUID id) {
        this.id = id;
    }

    protected String sanitize(String field, String item) {
        logError(field, item);
        return Objects.isNull(item) ? "" : item;
    }

    protected Integer sanitize(String field, Integer item) {
        return Objects.isNull(item) ? -1 : item;
    }

    private <T> void logError(String field, T item) {
        if(Objects.isNull(item)) {
            System.out.println(id + " " + field + " is NULL");
        }
    }
}
