package nickleby.algorithms.lectures.one;

import java.util.UUID;

public abstract class Animal extends Sanitizer {

    private UUID id;
    private String type;
    private String foodSource;
    private Integer numberOfLegs = 4;
    private String skinType = "Fur";

    //region CONSTRUCTORS
    protected Animal(UUID id) {
        super(id);
        this.id = id;
    }

    protected Animal(UUID id, String type, String foodSource) {
        this(id);

        this.type = type;
        this.foodSource = foodSource;
    }

    protected Animal(UUID id, String type, String foodSource, Integer numberOfLegs) {
        this(id, type, foodSource);

        this.numberOfLegs = numberOfLegs;
    }

    protected Animal(UUID id, String type, String foodSource, String skinType) {
        this(id, type, foodSource);

        this.skinType = skinType;
    }

    protected Animal(UUID id, String type, String foodSource, String skinType, Integer numberOfLegs) {
        this(id, type, foodSource, skinType);

        this.numberOfLegs = numberOfLegs;
    }
    //endregion CONSTRUCTORS


    //region GETTERS

    //endregion GETTERS


    //region SETTERS

    //endregion SETTERS
}
