package nickleby.algorithms.lectures.one;

import java.util.UUID;

public abstract class Sanitizer {

    private UUID id;

    protected Sanitizer(UUID id) {
        this.id = id;
    }
}
