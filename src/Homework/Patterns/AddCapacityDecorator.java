package Homework.Patterns;

// Декоратор для удвоения грузоподъемности
public class AddCapacityDecorator implements Transport {
    private Transport transport;

    public AddCapacityDecorator(Transport transport) {
        this.transport = transport;
    }

    @Override
    public int getCapacity() {
        return transport.getCapacity() * 2;
    }

    @Override
    public String getType() {
        return transport.getType() + " с увеличенной вместимостью";
    }
}
