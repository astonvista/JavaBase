package Homework.Patterns;

// Классы видов транспорта
public abstract class TransportUnit implements Transport {
    private int capacity;
    private String type;

    public TransportUnit() {
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void setType(String type) {
        this.type = type;
    }
}

class Truck extends TransportUnit {

    public Truck() {
        super.setCapacity(15);
        super.setType("Грузовик");
    }
}

class Plane extends TransportUnit {

    public Plane() {
        super.setCapacity(150);
        super.setType("Самолет");
    }
}

class Ship extends TransportUnit {

    public Ship() {
        super.setCapacity(1500);
        super.setType("Корабль");
    }
}
