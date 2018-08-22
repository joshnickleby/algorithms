package nickleby.algorithms.lectures.one;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.UUID;

public abstract class Sanitizer {

    private UUID id;

    protected Sanitizer(UUID id) {
        this.id = id;
    }

    protected String sanitize(String field, String item) {
        return Objects.isNull(item) ? "" : item;
    }

    protected Integer sanitize(String field, Integer item) {
        return Objects.isNull(item) ? -1 : item;
    }
}
