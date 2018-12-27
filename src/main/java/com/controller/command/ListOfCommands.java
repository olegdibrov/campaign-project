package com.controller.command;

public enum ListOfCommands {
    LOGIN(new AuthenticationCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),
    SPECIALITY(new ChooseSpecialityCommand()),
    UNIVERSITY(new ChooseUniversityCommand());

    private ICommand command;

    ListOfCommands(ICommand command) {
        this.command = command;
    }


    public ICommand getCommand(){
        return command;
    }


}
