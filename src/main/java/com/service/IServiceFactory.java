package com.service;

import com.service.implementation.*;

public interface IServiceFactory {
    RegistrationService getRegistrationService();
    AuthenticationService getAuthenticationService();
    UserService getUserService();
    SpecialityService getSpecialityService();
    DepartmentRequirementService getDepartmentRequirementService();
    DepartmentService getDepartmentService();
    ExamService getExamService();
    UniversityService getUniversityService();
}
