package homework.patterns;

public class Main {
    public static void main(String[] args) {
        // Создание Factory, Observer и объекта - логистической компании
        TransportFactory factory = new TransportFactory();
        LogisticsManager manager = new LogisticsManager();
        LogisticsCompany company = new LogisticsCompany(factory, manager);

        // Создание транспорта посредством фабрики и записью в лог Observer
        Transport truck = company.getReady(TransportType.TRUCK);
        Transport plane = company.getReady(TransportType.PLANE);
        Transport ship = company.getReady(TransportType.SHIP);

        // Добавление грузоподъемности с помощью декоратора
        Transport bigTruck = new AddCapacityDecorator(truck);
        Transport bigPlane = new AddCapacityDecorator(plane);
        Transport bigShip = new AddCapacityDecorator(ship);

        // Отправка транспорта с записью в лог Observer
        company.deploy(bigTruck);
        company.deploy(bigPlane);
        company.deploy(bigShip);

        // Печать лога Observer
        manager.printLog();
    }
}
