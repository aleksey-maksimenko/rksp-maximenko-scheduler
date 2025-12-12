package ru.maximenko.gate;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.maximenko.data.client.api.DataServiceApi;
import ru.maximenko.report.client.api.ReportServiceApi;
import ru.maximenko.data.client.model.UserEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedulerService {

    private final DataServiceApi readerApi;
    private final ReportServiceApi writerApi;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${scheduler.cron}")
    private String cronExpression;

    public SchedulerService(DataServiceApi readerApi, ReportServiceApi writerApi) {
        this.readerApi = readerApi;
        this.writerApi = writerApi;
    }

    @PostConstruct
    public void runOnStartup() {
        System.out.print("[START] ");
        System.out.println(LocalDateTime.now().format(formatter));
        sync();
    }

    @Scheduled(cron = "${scheduler.cron}")
    public void runOnSchedule() {
        System.out.print("\n[SCHEDULED] ");
        System.out.println(LocalDateTime.now().format(formatter));
        sync();
    }

    public void sync() {
        List<UserEvent> events = readerApi.getEvents();
        if (events.isEmpty()) return;
        System.out.println("Получено событий от data-service: " + events.size());
        if (events.isEmpty())
            return;
        System.out.println("  [first] eventType: " + events.get(0).getEventType());
        System.out.println("  [first] eventTime: " + events.get(0).getEventTime());

        List<ru.maximenko.report.client.model.UserEvent> reportEvents = events.stream()
                .map(e -> {
                    ru.maximenko.report.client.model.UserEvent re = new ru.maximenko.report.client.model.UserEvent();
                    re.setEventType(e.getEventType());
                    re.setEventTime(e.getEventTime());
                    return re;
                })
                .collect(Collectors.toList());
        writerApi.writeEvents(reportEvents);
        System.out.println("Записано событий в report-service: " + reportEvents.size());
    }
}

