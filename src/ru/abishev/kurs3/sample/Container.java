package ru.abishev.kurs3.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Apr 7, 2010
 * Time: 9:29:44 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Container {
    public static Container instance;

    private Map<String, Object> components = new HashMap<String, Object>();

    private Container() {
    }

    public static Container getContainer() {
        if (instance == null) {
            instance = new Container();

            instance.addComponent("generator", new PlainTextReportGenerator());
            instance.addComponent("statisticSource", new YearStatisticSource());

//            ReportService service = new ReportService(
//                    (ReportGenerator) instance.getComponent("generator"),
//                    (StatisticSource) instance.getComponent("statisticSource"));

            ReportService service = new ReportService();
            service.setGenerator((ReportGenerator) instance.getComponent("generator"));
            service.setStatisticSource((StatisticSource) instance.getComponent("statisticSource"));
            instance.addComponent("reportService", service);
        }

        return instance;
    }

    private void addComponent(String id, Object object) {
        components.put(id, object);
    }

    public Object getComponent(String id) {
        return components.get(id);
    }
}
