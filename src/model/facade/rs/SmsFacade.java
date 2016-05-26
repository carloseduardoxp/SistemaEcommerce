package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.domain.Sms;
import model.service.SmsService;

@Path("/sms")
@Produces({MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class SmsFacade {
	
	@Inject
	private SmsService smsService;
	
	@GET
	public List<Sms> getSmsSemParametros() {
		return smsService.getSms(new Sms());
	}
	
	@GET
	@Path("/{codigoSms}")
	public List<Sms> getSms(
			@PathParam("codigoSms")Integer codigoSms) {
		Sms sms = new Sms();
		sms.setCodigo(codigoSms);
		return smsService.getSms(sms);
	}
	
	@POST
	public Sms enviarSms(Sms sms) {
		return smsService.salvar(sms);		
	}

}
