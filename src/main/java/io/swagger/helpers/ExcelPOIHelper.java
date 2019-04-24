package io.swagger.helpers;

import io.swagger.model.Dataset;
import io.swagger.model.Organization;
import io.swagger.model.Reuse;
import io.swagger.repository.OrganizationRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ExcelPOIHelper {

    private static final Logger log = LoggerFactory.getLogger(ExcelPOIHelper.class);

    private FormDataWithFile formDataWithFile; //Admin mapping
    private ExcelColumns excelColumns = new ExcelColumns(); //Indexes

    @Autowired
    private EntityManagerFactory entityManagerFactory; //Hibernate

    @Autowired
    OrganizationRepository organizationRepository;

    //Process variable
    //Initialization
    XSSFWorkbook workbook;
    EntityManager entityManager;

    //Declare tree for IDs, will be used to detect duplicates and avoid DB exceptions
    Map<String,Void> orgIndex = new TreeMap<>();
    Map<String,Void> datIndex = new TreeMap<>();
    Map<String,Void> reuIndex = new TreeMap<>();

    //Declare some counters
    Integer datasetCounter = 0;
    Integer reusesCounter = 0;
    Integer organizationsCounter = 0;
    Integer datasetReusesRelationsCounter = 0;

    public void readExcel(String fileLocation, FormDataWithFile formData) throws IOException {

        formDataWithFile = formData;
        // Show current mapping
        log.info(formDataWithFile.toString());

        FileInputStream fis = new FileInputStream(new File(fileLocation));

        if (fileLocation.endsWith(".xls")) {
            readHSSFWorkbook(fis);
        } else if (fileLocation.endsWith(".xlsx")) {
            readXSSFWorkbook(fis);
        }
    }

    //TODO metodo para leer .xlsx
    private void readXSSFWorkbook(FileInputStream fis) throws IOException{

        try {
            workbook = new XSSFWorkbook(fis);

            //Datasets process
            //TODO Añadir el resto de atributos en la llamada desde la API para ver si funciona al completo.
            //Select first sheet: Datasets Sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            //---First Row: Identify column names and save their index in ExcelColumns
            XSSFRow row = sheet.getRow(sheet.getFirstRowNum());
            //Iterate between cells
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    String columnName = cell.getStringCellValue();
                    log.info("Column name: " + columnName);
                    if (columnName.equals(formDataWithFile.getD_id()))
                        excelColumns.setD_id(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_title()))
                        excelColumns.setD_title(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_description()))
                        excelColumns.setD_description(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_createdAt()))
                        excelColumns.setD_createdAt(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_lastModified()))
                        excelColumns.setD_lastModified(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_url()))
                        excelColumns.setD_url(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_image()))
                        excelColumns.setD_image(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_views()))
                        excelColumns.setD_views(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_frequency()))
                        excelColumns.setD_frequency(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_reusesNum()))
                        excelColumns.setD_reusesNum(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_license()))
                        excelColumns.setD_license(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_organization_name()))
                        excelColumns.setD_organization_name(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getD_organization_id()))
                        excelColumns.setD_organization_id(cell.getColumnIndex());
                }
            }
            log.info("Dataset columns selected: " + excelColumns.toString());
            //---Second to last row:
            //Initialize EntityManager for Hibernate
            entityManager = entityManagerFactory.createEntityManager();


            //For every row:
            for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    //Create new dataset object and new organization object
                    Dataset dataset = new Dataset();
                    Organization organization = new Organization();

                    //For every cell, save att in dataset object
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null && cell.getCellType()!= CellType.BLANK) {
                            //Compare if the current column is one of the specified columns in ExcelColumns. If so, update the Dataset object
                            if(excelColumns.getD_id()!=null && j==excelColumns.getD_id())
                                dataset.setId(cell.getStringCellValue());
                            if(excelColumns.getD_title()!=null && j==excelColumns.getD_title())
                                dataset.setTitle(cell.getStringCellValue());
                            if(excelColumns.getD_description()!=null && j==excelColumns.getD_description())
                                dataset.setDescription(cell.getStringCellValue());
                            if(excelColumns.getD_createdAt()!=null && j==excelColumns.getD_createdAt())
                                dataset.setCreatedAt(cell.getDateCellValue());
                            if(excelColumns.getD_lastModified()!=null && j==excelColumns.getD_lastModified())
                                dataset.setLastModified(cell.getDateCellValue());
                            if(excelColumns.getD_url()!=null && j==excelColumns.getD_url())
                                dataset.setUrl(cell.getStringCellValue());
                            if(excelColumns.getD_image()!=null && j==excelColumns.getD_image())
                                dataset.setImage(cell.getStringCellValue());
                            if(excelColumns.getD_views()!=null && j==excelColumns.getD_views())
                                dataset.setViews(cell.getStringCellValue());
                            if(excelColumns.getD_frequency()!=null && j==excelColumns.getD_frequency())
                                dataset.setFrequency(cell.getStringCellValue());
                            if(excelColumns.getD_reusesNum()!=null && j==excelColumns.getD_reusesNum())
                                dataset.setReusesNum((int) cell.getNumericCellValue());
                            if(excelColumns.getD_license()!=null && j==excelColumns.getD_license())
                                dataset.setLicense(cell.getStringCellValue());
                            //If ORG is present, create new ORG and save att in org object
                            if(excelColumns.getD_organization_name()!=null && j==excelColumns.getD_organization_name())
                                organization.setTitle(cell.getStringCellValue());
                            if(excelColumns.getD_organization_id()!=null && j==excelColumns.getD_organization_id())
                                organization.setId(cell.getStringCellValue());
                            //Next row
                        }
                    } //End cell iterator

                    //Save org first if present and add it to dataset
                    if (organization.getId()!=null) {
                        saveOrganization(organization);
                        //Always bind dataset to its organization
                        dataset.setOrganization(organization);
                    }
                    //Save dataset
                    if (dataset.getId()!=null){
                        saveDataset(dataset);
                    }
                    entityManager.clear();

                }
            } //End row iterator

            //Reuses process

            //Select second sheet: Reuses Sheet
            sheet = workbook.getSheetAt(1);

            //---First Row: Identify column names and save their index in ExcelColumns
            row = sheet.getRow(sheet.getFirstRowNum());
            //Iterate between cells
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    String columnName = cell.getStringCellValue();
                    log.info("Column name: " + columnName);
                    if (columnName.equals(formDataWithFile.getR_id()))
                        excelColumns.setR_id(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_title()))
                        excelColumns.setR_title(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_description()))
                        excelColumns.setR_description(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_createdAt()))
                        excelColumns.setR_createdAt(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_lastModified()))
                        excelColumns.setR_lastModified(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_url()))
                        excelColumns.setR_url(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_image()))
                        excelColumns.setR_image(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_views()))
                        excelColumns.setR_views(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_type()))
                        excelColumns.setR_type(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_reviewsNum()))
                        excelColumns.setR_reviewsNum(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score()))
                        excelColumns.setR_score(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score5()))
                        excelColumns.setR_score5(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score4()))
                        excelColumns.setR_score4(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score3()))
                        excelColumns.setR_score3(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score2()))
                        excelColumns.setR_score2(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_score1()))
                        excelColumns.setR_score1(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_downloads()))
                        excelColumns.setR_downloads(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_organization_name()))
                        excelColumns.setR_organization_name(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getR_organization_id()))
                        excelColumns.setR_organization_id(cell.getColumnIndex());
                }
            }
            log.info("Reuses columns selected: " + excelColumns.toString());

            //---Second to last row:

            //For every row:
            for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    //Create new reuse object and new organization object
                    Reuse reuse = new Reuse();
                    Organization organization = new Organization();

                    //For every cell, save att in reuse object
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null && cell.getCellType()!= CellType.BLANK) {
                            //Compare if the current column is one of the specified columns in ExcelColumns. If so, update the Reuse object
                            if(excelColumns.getR_id()!=null && j==excelColumns.getR_id())
                                reuse.setId(cell.getStringCellValue());
                            if(excelColumns.getR_title()!=null && j==excelColumns.getR_title())
                                reuse.setTitle(cell.getStringCellValue());
                            if(excelColumns.getR_description()!=null && j==excelColumns.getR_description())
                                reuse.setDescription(cell.getStringCellValue());
                            if(excelColumns.getR_createdAt()!=null && j==excelColumns.getR_createdAt())
                                reuse.setCreatedAt(cell.getDateCellValue());
                            if(excelColumns.getR_lastModified()!=null && j==excelColumns.getR_lastModified())
                                reuse.setLastModified(cell.getDateCellValue());
                            if(excelColumns.getR_url()!=null && j==excelColumns.getR_url())
                                reuse.setUrl(cell.getStringCellValue());
                            if(excelColumns.getR_image()!=null && j==excelColumns.getR_image())
                                reuse.setImage(cell.getStringCellValue());
                            if(excelColumns.getR_views()!=null && j==excelColumns.getR_views())
                                reuse.setViews(cell.getStringCellValue());
                            if(excelColumns.getR_type()!=null && j==excelColumns.getR_type())
                                reuse.setType(cell.getStringCellValue());
                            if(excelColumns.getR_reviewsNum()!=null && j==excelColumns.getR_reviewsNum())
                                reuse.setReviewsNum((int) cell.getNumericCellValue());
                            if(excelColumns.getR_score()!=null && j==excelColumns.getR_score())
                                reuse.setScore((float) cell.getNumericCellValue());
                            if(excelColumns.getR_score5()!=null && j==excelColumns.getR_score5())
                                reuse.setScore5((float) cell.getNumericCellValue());
                            if(excelColumns.getR_score4()!=null && j==excelColumns.getR_score4())
                                reuse.setScore4((float) cell.getNumericCellValue());
                            if(excelColumns.getR_score3()!=null && j==excelColumns.getR_score3())
                                reuse.setScore3((float) cell.getNumericCellValue());
                            if(excelColumns.getR_score2()!=null && j==excelColumns.getR_score2())
                                reuse.setScore2((float) cell.getNumericCellValue());
                            if(excelColumns.getR_score1()!=null && j==excelColumns.getR_score1())
                                reuse.setScore1((float) cell.getNumericCellValue());
                            if(excelColumns.getR_downloads()!=null && j==excelColumns.getR_downloads())
                                reuse.setDownloads((int) cell.getNumericCellValue());

                            //If ORG is present, create new ORG and save att in org object
                            if(excelColumns.getR_organization_name()!=null && j==excelColumns.getR_organization_name())
                                organization.setTitle(cell.getStringCellValue());
                            if(excelColumns.getR_organization_id()!=null && j==excelColumns.getR_organization_id())
                                organization.setId(cell.getStringCellValue());
                            //Next row
                        }
                    } //End cell iterator

                    //Save org first if present and add it to reuse
                    if (organization.getId()!=null) {
                        saveOrganization(organization);
                        //Always bind reuse to its organization
                        reuse.setOrganization(organization);
                    }
                    //Save reuse
                    if (reuse.getId()!=null){
                        saveReuse(reuse);
                    }
                    entityManager.clear();
                }
            } //End row iterator

            //Dataset-Reuse Relation process
            //Select third sheet: Dataset-Reuse Relations Sheet

            sheet = workbook.getSheetAt(2);

            //---First Row: Identify column names and save their index in ExcelColumns
            row = sheet.getRow(sheet.getFirstRowNum());
            //Iterate between cells
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    String columnName = cell.getStringCellValue();
                    log.info("Column name: " + columnName);
                    if (columnName.equals(formDataWithFile.getDr_id_dataset()))
                        excelColumns.setDr_id_dataset(cell.getColumnIndex());
                    if (columnName.equals(formDataWithFile.getDr_id_reuse()))
                        excelColumns.setDr_id_reuse(cell.getColumnIndex());
                }
            }
            log.info("Dataset-Reuses Relation columns selected: " + excelColumns.toString());

            //---Second to last row:
            //Start a new transaction
            log.info("Relations process start");
            entityManager.getTransaction().begin();

            //For every row:
            for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    String dataset_id = null;
                    String reuse_id = null;
                    //For every cell, save att in reuse object
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null && cell.getCellType()!= CellType.BLANK) {
                            //Compare if the current column is one of the specified columns in ExcelColumns. If so, update the variables
                            if(excelColumns.getDr_id_dataset()!=null && j==excelColumns.getDr_id_dataset())
                                dataset_id=cell.getStringCellValue();
                            if(excelColumns.getDr_id_reuse()!=null && j==excelColumns.getDr_id_reuse())
                                reuse_id=cell.getStringCellValue();

                            //Next row
                        }
                    } //End cell iterator

                    //Insert relation into DB
                    if (dataset_id!=null && reuse_id!=null){
                        entityManager.createNativeQuery("INSERT INTO `dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('" + dataset_id + "','" + reuse_id +"')").executeUpdate();
                        datasetReusesRelationsCounter++;
                    }
                }
            } //End row iterator
            //Commit and close current session
            entityManager.getTransaction().commit();
            log.info("Relations process finished");
            entityManager.close();



        } finally {
            log.info("Excel process statistics: ");
            log.info("Datasets saved: " + datasetCounter);
            log.info("Reuses saved: " + reusesCounter);
            log.info("Organizations saved: " + organizationsCounter);
            log.info("Dataset-Reuse Relations saved: " + datasetReusesRelationsCounter);
            if (workbook != null) {
                workbook.close();
            }
        }

    }


    //TODO metodo para leer .xls. En principio es todo igual, cambiando los tipos XSSF
    private void readHSSFWorkbook(FileInputStream fis) {
    }

    private void saveOrganization(Organization organization){
        if(orgIndex.containsKey(organization.getId())){
            log.info("Duplicated: " + organization.getId() + " organization already exists. Skip insert");
        }else{
            orgIndex.put(organization.getId(),null);
            save(organization);
            organizationsCounter++;
            log.info("Organization saved: " + organization.toString());
        }
    }

    private void saveDataset(Dataset dataset){
        if(datIndex.containsKey(dataset.getId())){
            log.info("Duplicated: " + dataset.getId() + " dataset already exists. Skip insert");
        }else{
            datIndex.put(dataset.getId(),null);
            save(dataset);
            datasetCounter++;
            log.info("Dataset saved: " + dataset.toString());
        }
    }

    private void saveReuse(Reuse reuse){
        if(reuIndex.containsKey(reuse.getId())){
            log.info("Duplicated: " + reuse.getId() + " reuse already exists. Skip insert");
        }else{
            reuIndex.put(reuse.getId(),null);
            save(reuse);
            reusesCounter++;
            log.info("Reuse saved." + reuse.toString());
        }
    }

    private void save(Object object){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }
}
