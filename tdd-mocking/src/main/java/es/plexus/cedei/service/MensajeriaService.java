package es.plexus.cedei.service;

import es.plexus.cedei.model.Mensaje;

public interface MensajeriaService {
    void enviarMensaje(String correo, Mensaje mensaje);
}
