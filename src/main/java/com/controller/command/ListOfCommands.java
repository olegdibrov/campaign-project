package com.controller.command;

public enum ListOfCommands {
    LOGIN(new AuthorizationCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),
    SPECIALITY(new ChooseSpecialityCommand()),
    UNIVERSITY(new ChooseUniversityCommand()),
    DEPARTMENT(new ChooseDepartmentCommand()),
    FINISH(new RegisterToExamCommand()),
    EXAMS(new ShowUnmarkedExamsCommand()),
    ADD_MARK(new AddMarkCommand()),
    RATING(new ShowRatingCommand()),
    LOCALIZATION(new LocalizationCommand()),
    SHOW_EXAMS(new ShowExamsCommand()),
    SEND_NOTIFICATION(new SendNotificationCommand()),
    CABINET(new GoToCabinet()),
    INDEX(new GoToMainPage());

    private ICommand command;

    ListOfCommands(ICommand command) {
        this.command = command;
    }


    public ICommand getCommand(){
        return command;
    }


}
