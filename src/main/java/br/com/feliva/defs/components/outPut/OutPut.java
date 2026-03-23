package br.com.feliva.defs.components.outPut;

import java.io.IOException;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UIOutput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;

@FacesComponent(OutPut.COMPONENT_TYPE)
public class OutPut extends UIOutput {

    public static final String COMPONENT_TYPE = "defs.output";
    public static final String COMPONENT_FAMILY = "br.com.feliva.component";

    public OutPut() {
        setRendererType(null);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        if (!isRendered()) {
            return;
        }
        String value = (String) getValue();
        ResponseWriter responseWriter = context.getResponseWriter();
        String clientId = super.getClientId(context);
        responseWriter.startElement("span", this);
        responseWriter.writeAttribute("id", clientId, "id");
        if (null != value) {
            responseWriter.writeText("hello: " + value, "value");
        }
        responseWriter.endElement("span");
    }
}