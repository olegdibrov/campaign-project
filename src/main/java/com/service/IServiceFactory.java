package com.service;

import com.service.implementation.*;
import com.service.interfaces.IAuthenticationService;

public interface IServiceFactory {
    RegistrationService getRegistrationService();
    IAuthenticationService getAuthenticationService();
    UserService getUserService();
    SpecialityService getSpecialityService();
    DepartmentRequirementService getDepartmentRequirementService();
    DepartmentService getDepartmentService();
    ExamService getExamService();
    UniversityService getUniversityService();
    RatingService getRatingService();
}
