package me.xuanxi.spark.api.data;

public enum SportType {
    basketball("篮球"),
    running("跑步"),
    walk("步行"),
    badminton("羽毛球"),
    skateboard("滑板"),
    swimming("游泳");

    private final String sportTypeName;
    SportType(String sportTypeName){
        this.sportTypeName = sportTypeName;
    }

    public static SportType fromString(String text) {
        for (SportType sportType : SportType.values()) {
            if (sportType.sportTypeName.equalsIgnoreCase(text)) {
                return sportType;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }

    @Override
    public String toString() {
        return this.sportTypeName;
    }
}
