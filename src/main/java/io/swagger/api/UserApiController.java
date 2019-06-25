package io.swagger.api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.swagger.helpers.ExcelPOIHelper;
import io.swagger.helpers.FormDataWithFile;
import io.swagger.helpers.RankingCalculator;
import io.swagger.model.User;
import io.swagger.model.Weight;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@RestController
public class UserApiController implements UserApi {

    // TODO Una vez esté en la versión definitiva, eliminar los métodos que no se usarán nunca tanto de aquí
    //  como de la interfaz superior.
    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final String adminUsername = "opendataranks_admin";
    private final String adminPwd = "opendataranks_api";

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private String fileLocation;

    @Resource(name = "excelPOIHelper")
    private ExcelPOIHelper excelPOIHelper;

    @Resource(name = "rankingCalculator")
    private RankingCalculator rankingCalculator;

    @Autowired
    private EntityManagerFactory entityManagerFactory; //Hibernate

    @Autowired
    WeightRepository weightRepository;


    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

//    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body) {
//        String accept = request.getHeader("Accept");
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
//    }

//    public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username) {
//        String accept = request.getHeader("Accept");
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
//    }

    public ResponseEntity<Void> deleteWeightById(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username,@ApiParam(value = "The id that needs to be fetched",required=true) @PathVariable("weightId") Integer weightId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Weight>> getAllWeights(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Weight>>(HttpStatus.NOT_IMPLEMENTED);
    }

//    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing.",required=true) @PathVariable("username") String username) {
//        String accept = request.getHeader("Accept");
//        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
//    }

    public ResponseEntity<Weight> getWeightById(@ApiParam(value = "The name that needs to be fetched",required=true) @PathVariable("username") String username,@ApiParam(value = "The id that needs to be fetched",required=true) @PathVariable("weightId") Integer weightId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Weight>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * A test Endpoint which returns a hello world string.
     * @param name
     * @return
     */
    public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello administrator "+name+"!!";
    }

    /**
     * Autenticates user into API.
     * @param username Username
     * @param pwd Password
     * @return
     */
    public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        // TODO Comprobar contra la BD en lugar de en el código?

        if ( username.equals(adminUsername) && pwd.equals(adminPwd) ) {
            User user = new User();
            String token = getJWTToken(username);
            user.setUsername(username);
            user.setToken(token);
            return new ResponseEntity<User> (user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Builds a new token for the given user
     * @param username Username
     * @return
     */
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))   // Token will last for 10 minutes
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

//    public ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body,@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username) {
//        String accept = request.getHeader("Accept");
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
//    }


    // ADMINS section. Path: /admins
    // TODO Seccion para los administradores: Subida de fichero (hecho), añadir nueva ponderacion
    // TODO ¿Sería correcto lanzar el procesamiento del fichero en un thread a parte para no bloquear la respuesta al admin?

    /**
     * Adds a new weight to the database and calculates the necesary rankings.
     * @param weight
     * @return
     */
    public ResponseEntity<Void> addWeight(@ApiParam(value = "Weight to add"  )  @Valid @RequestBody Weight weight) {

        log.info("Weight validation...");
        if (weight.isValid()) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            log.info("Adding new weight to DB.");
            entityManager.createNativeQuery("INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('"+ weight.getId() +"', '"+ weight.getDownloadsVal() +"', '"+ weight.getName() +"', '"+ weight.getReviewsNumVal() +"', '"+ weight.getScoreVal() +"')").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            // Calculate rankings for the new weight
            rankingCalculator.calculateReusesRankingsFromWeight(weight);
            rankingCalculator.calculateDatasetsRankingsFromWeight(weight);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * Delete all of the database content but weights
     * @return
     */
    public ResponseEntity<Void> resetDatabase() {
        deleteDatabaseContent();
        return new ResponseEntity (HttpStatus.OK);
    }


    /**
     * Upload a file and stores the mapping given by de administrator. After that, populates DB with new info.
     * @param formDataWithFile Data: Mapping + File
     * @return
     */
    public ResponseEntity<Void> uploadFileAndMapping(FormDataWithFile formDataWithFile) {
        try {
            saveFileInLocal(formDataWithFile.getFile());
            log.info("File sucesfully copied in server system");
            //Call excelPOIHelper and save file content into DB
            excelPOIHelper.readExcel(fileLocation, formDataWithFile);
            //TODO Mover el procesamiento del fichero y el calculo de ponderaciones a un Thread aparte.
            //Call rankingCalculator
            rankingCalculator.calculateReuseRankings();
            rankingCalculator.calculateDatasetsRankings();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Problems found during the upload");
            // TODO Se deberia limpiar/borrar las tablas de la DB para evitar residuos de la carga fallida
            return new ResponseEntity ("Problems found during the upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity (HttpStatus.OK);
    }

    /**
     * Saves a MultipartFile in local files.
     * @param multipartFile
     * @throws Exception
     */
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

    /**
     * Delete all of the database content but weights.
     */
    private void deleteDatabaseContent() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        log.info("User controller: Delete process start.");
        entityManager.getTransaction().begin();

        log.info("User controller: Setting FK checks to 0");
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        log.info("User controller: Deleting dataset_reuse.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.dataset_reuse").executeUpdate();
        log.info("User controller: Deleting dataset_tag.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.dataset_tag").executeUpdate();
        log.info("User controller: Deleting dataset_weight.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.dataset_weight").executeUpdate();
        log.info("User controller: Deleting reuse_tag.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.reuse_tag").executeUpdate();
        log.info("User controller: Deleting reuse_weight.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.reuse_weight").executeUpdate();
        log.info("User controller: Deleting tag.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.tag").executeUpdate();
        log.info("User controller: Deleting dataset.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.dataset").executeUpdate();
        log.info("User controller: Deleting reuse.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.reuse").executeUpdate();
        log.info("User controller: Deleting organization.");
        entityManager.createNativeQuery("TRUNCATE opendataranks_db.organization").executeUpdate();
        log.info("User controller: Restoring FK checks to 1");
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
        log.info("User controller: Delete process done. DB has been cleared.");
    }

}
