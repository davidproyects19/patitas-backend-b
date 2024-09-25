package pe.edu.cibertec.patitas_backend_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.patitas_backend_b.DTO.LoginRequestDTO;
import pe.edu.cibertec.patitas_backend_b.DTO.LoginResponseDTO;
import pe.edu.cibertec.patitas_backend_b.service.AutenticacionService;

import java.io.IOException;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {


        try {
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);
            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "ERROR: USUARIO NO ENCONTRADO",
                        "", "");
            }
            return new LoginResponseDTO("00", "", datosUsuario[0],
                    datosUsuario[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new LoginResponseDTO("99", "ERROR: Ocurrio un problema", "", "");
        }

    }
}

