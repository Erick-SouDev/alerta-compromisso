package erick.br.services.agenda;

import java.util.concurrent.ScheduledExecutorService;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class MonitoramentoEventoServices {


	@Scheduled(fixedDelay = 5000 , initialDelay = 2000)
	public  void monitoradataEventos()
	{
		
		 
		 
		 
	}
}
