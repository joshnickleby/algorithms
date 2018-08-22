package nickleby.algorithms.lectures.one.finished;

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
    public UUID id() { return id; }
    public String type() { return sanitize("type", type); }
    public String foodSource() { return sanitize("foodSource", foodSource); }
    public Integer numberOfLegs() { return sanitize("numberOfLegs", numberOfLegs); }
    public String skinType() { return sanitize("skinType", skinType); }
    //endregion GETTERS


    //region SETTERS
    public Animal id(UUID id) { this.id = id; return this; }
    public Animal type(String type) { this.type = type; return this; }
    public Animal foodSource(String foodSource) { this.foodSource = foodSource; return this; }
    public Animal numberOfLegs(Integer numberOfLegs) { this.numberOfLegs = numberOfLegs; return this; }
    public Animal skinType(String skinType) { this.skinType = skinType; return this; }
    //endregion SETTERS
}
