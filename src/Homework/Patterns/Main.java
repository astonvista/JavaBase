package Homework.Patterns;

public class Main {
    public static void main(String[] args) {
        TransportFactory factory = new TransportFactory();
        LogisticsManager manager = new LogisticsManager();
        LogisticsCompany company = new LogisticsCompany(factory, manager);

        Transport truck = company.getReady(TransportType.TRUCK);
        Transport plane = company.getReady(TransportType.PLANE);
        Transport ship = company.getReady(TransportType.SHIP);

        Transport bigTruck = new AddCapacityDecorator(truck);
        Transport bigPlane = new AddCapacityDecorator(plane);
        Transport bigShip = new AddCapacityDecorator(ship);

        company.deploy(bigTruck);
        company.deploy(bigPlane);
        company.deploy(bigShip);

        manager.printLog();
    }
}
