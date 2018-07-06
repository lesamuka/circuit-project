package br.com.fk1.quartz.webservice.pojo;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe "EventoAutomaticoPojo" representação da classe "EventoAutomatico"
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
public class EventoAutomaticoPojo implements Serializable {

    private static final long serialVersionUID = 5918496610496327193L;

    private Integer id;
    private String tipoEventoAutomatico;
    private String cronBuilder;
    private Date proximaExecucaoDateHora;
    private Boolean excluido = Boolean.FALSE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEventoAutomatico() {
        return tipoEventoAutomatico;
    }

    public void setTipoEventoAutomatico(String tipoEventoAutomatico) {
        this.tipoEventoAutomatico = tipoEventoAutomatico;
    }

    public String getCronBuilder() {
        return cronBuilder;
    }

    public void setCronBuilder(String cronBuilder) {
        this.cronBuilder = cronBuilder;
    }

    public Date getProximaExecucaoDateHora() {
        return proximaExecucaoDateHora;
    }

    public void setProximaExecucaoDateHora(Date proximaExecucaoDateHora) {
        this.proximaExecucaoDateHora = proximaExecucaoDateHora;
    }
    
    public boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
