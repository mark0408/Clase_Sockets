package socket.operacion.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RespuestaCoronelDTO implements Serializable{

	private String mensaje;
	private String idCoronel;
}
