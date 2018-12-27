package com.service.implementation;

import com.model.dao.AbstractDAO;
import com.model.dao.connection.ConnectionMySQL;
import com.model.dao.factory.DaoFactory;
import com.service.IServiceFactory;
import com.util.encoder.IEncoder;
import com.util.encoder.Sha256Encoder;
import org.apache.log4j.Logger;

public class ServiceFactory implements IServiceFactory {
    private final static Logger LOGGER = Logger.getLogger(ServiceFactory.class);
    private static ServiceFactory instance;

    private RegistrationService registrationService;
    private AuthenticationService authenticationService;
    private UserService userService;
    private SpecialityService specialityService;
    private DepartmentRequirementService departmentRequirementService;
    private DepartmentService departmentService;
    private ExamService examService;
    private UniversityService universityService;


    public static void init(DaoFactory daoFactory, IEncoder passwordEncoder){
        instance = new ServiceFactory(daoFactory, passwordEncoder);
    }

    public ServiceFactory(DaoFactory daoFactory, IEncoder passwordEncoder) {
        registrationService = new RegistrationService(daoFactory, passwordEncoder);
        authenticationService = new AuthenticationService(daoFactory, passwordEncoder);
        userService = new UserService(daoFactory);
        specialityService = new SpecialityService(daoFactory);
        departmentRequirementService = new DepartmentRequirementService(daoFactory);
        departmentService = new DepartmentService(daoFactory);
        examService = new ExamService(daoFactory);
        universityService = new UniversityService(daoFactory);
    }

    public static ServiceFactory getInstance() {
        if(instance == null) {
            LOGGER.debug("Default init from MySQL DAO factory and sha 256 encoder");
            init(DaoFactory.getInstance(), new Sha256Encoder());
        }
        return instance;
    }



    public static void setInstance(ServiceFactory instance) {
        ServiceFactory.instance = instance;
    }

    public void setSpecialityService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    public SpecialityService getSpecialityService() {
        return specialityService;
    }

    @Override
    public DepartmentRequirementService getDepartmentRequirementService() {
        return departmentRequirementService;
    }

    @Override
    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    @Override
    public ExamService getExamService() {
        return examService;
    }

    @Override
    public UniversityService getUniversityService() {
        return universityService;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
