package homework.patterns;

// Фабрика для создания транспорта
public class TransportFactory {

    public Transport create(TransportType type) {
        Transport result = null;
        switch (type) {
            case SHIP -> result = new Ship();
            case PLANE -> result = new Plane();
            case TRUCK -> result = new Truck();
        }
        return result;
    }
}
