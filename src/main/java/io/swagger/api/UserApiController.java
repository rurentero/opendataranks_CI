package io.swagger.api;

import io.swagger.helpers.ExcelPOIHelper;
import io.swagger.helpers.FormDataWithFile;
import io.swagger.model.User;
import io.swagger.model.Weight;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private String fileLocation;

    @Resource(name = "excelPOIHelper")
    private ExcelPOIHelper excelPOIHelper;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addWeight(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username,@ApiParam(value = "Weight to add"  )  @Valid @RequestBody Weight body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteWeightById(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username,@ApiParam(value = "The id that needs to be fetched",required=true) @PathVariable("weightId") Integer weightId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Weight>> getAllWeights(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Weight>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing.",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Weight> getWeightById(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username,@ApiParam(value = "The id that needs to be fetched",required=true) @PathVariable("weightId") Integer weightId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Weight>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body,@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }


    // ADMINS section. Path: /admins
    // TODO Seccion para los administradores: Subida de fichero, añadir nueva ponderacion

    // TODO algoritmo de carga (leer celdas): https://stackoverflow.com/questions/19346607/conversion-of-excel-data-to-mysql-tables
    // TODO Controlador: https://github.com/eugenp/tutorials/blob/master/spring-mvc-java/src/main/java/com/baeldung/web/controller/ExcelController.java
    // TODO poihelper https://github.com/eugenp/tutorials/blob/master/spring-mvc-java/src/main/java/com/baeldung/excel/ExcelPOIHelper.java
    public ResponseEntity<Void> uploadFileAndMapping(FormDataWithFile formDataWithFile) {
        // TODO Subir fichero al servidor: https://www.adictosaltrabajo.com/2012/05/03/upload-file-spring/
        // Seria correcto recoger el fichero y guardarlo siempre con el mismo nombre predeterminado en el servidor, asi no mantenemos la ruta que dio el usuario
        // Guardar el fichero en local y luego llamar al helper para que actualice la BD
        try {
            saveFileInLocal(formDataWithFile.getFile());
            log.info("File sucesfully copied in server system");
            //Call excelPOIHelper and save file content into DB
            excelPOIHelper.readExcel(fileLocation, formDataWithFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Problems found during the upload");
            return new ResponseEntity ("Problems found during the upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity (HttpStatus.OK);
    }

    //TODO Probar que el fichero se sube/guarda correctamente.
    private void saveFileInLocal(MultipartFile multipartFile) throws Exception {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        File localFile = new File(path.substring(0, path.length() - 1) +"/"+multipartFile.getOriginalFilename());
        fileLocation = localFile.getAbsolutePath();
        log.info("saveFileInLocal: File Path : " + localFile.getAbsolutePath());

        FileOutputStream os = null;

        try {

            os = new FileOutputStream(localFile);
            os.write(multipartFile.getBytes());

        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
