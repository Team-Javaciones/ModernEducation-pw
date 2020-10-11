package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.AsesorService;

@Named("asesorView")
@ViewScoped
public class AsesorView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AsesorService asesorService;
	@Inject
	private AlumnoService alumnoService;
	
	private Asesor asesor;
	
	private String password1;
	private String password2;
	
	@PostConstruct
	public void init() {
		this.cleanForm();
	}
	
	public void cleanForm() {
		this.asesor = new Asesor();
	}
	
	public void newAsesor() {
		boolean uniqueUsername = true;
		boolean passwordConfirmation = false;
		try {
			Optional<Asesor> optionalAsesor = asesorService.findByUsername(asesor.getUsername());
			Optional<Alumno> optionalAlumno = alumnoService.findByUsername(asesor.getUsername());
			if (optionalAsesor.isPresent()) 
				if(!optionalAsesor.get().getId().equals(asesor.getId())) 
					uniqueUsername = false;								
			
			if (optionalAlumno.isPresent()) 	
				uniqueUsername = false;								
			
			if(password1.equals(password2)) {
				passwordConfirmation = true;
				this.asesor.setPassword(password1);
			}
			if(uniqueUsername == true && passwordConfirmation == true) {
				asesorService.save(this.asesor);
				cleanForm();
				this.addMessage("Se registró el asesor satisfactoriamente");			
			}
			else if (uniqueUsername == false){
				this.addMessage("El usuario '" + asesor.getUsername() + "' ya se encuentra registrado.");
			}		
			else if (passwordConfirmation == false) {
				this.addMessage("Las contraseñas no coinciden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public AsesorService getAsesorService() {
		return asesorService;
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public Asesor getAsesor() {
		return asesor;
	}	
}
