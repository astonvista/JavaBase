package Homework.Patterns;

import java.util.Date;

// Класс логистической компании
public class LogisticsCompany {
    private TransportFactory factory;
    private LogisticsManager manager;

    public LogisticsCompany(TransportFactory factory, LogisticsManager manager) {
        this.factory = factory;
        this.manager = manager;
    }

    // Подготовка транспорта с записью в лог менеджера-observer
    public Transport getReady(TransportType type) {
        Transport result = factory.create(type);
        manager.submitStatus(new Date() + " " + result.getType() + " грузоподъемностью " + result.getCapacity()
                + " тонн готов к погрузке.");
        return result;
    }

    // Отправка транспорта с записью в лог менеджера-observer
    public void deploy(Transport transport) {
        manager.submitStatus(new Date() + " " + transport.getType() + " грузоподъемностью " + transport.getCapacity()
                + " тонн отправлен.");
    }
}
