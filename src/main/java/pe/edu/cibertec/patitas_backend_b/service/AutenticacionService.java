package pe.edu.cibertec.patitas_backend_b.service;


import pe.edu.cibertec.patitas_backend_b.DTO.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;


}
