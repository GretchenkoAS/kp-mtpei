package com.nyha.webfinal.controller.command;

import com.nyha.webfinal.controller.command.impl.*;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    CHANGE_PASSWORD {
        {
            this.command = new ChangePasswordCommand();
        }
    },
//    CHANGE_ROLE {
//        {
//            this.command = new ChangeRoleCommand();
//        }
//    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SHOW_USERS {
        {
            this.command = new ShowUsersCommand();
        }
    },
    CHANGE_LOCALE {
        {
            this.command = new ChangeLocaleCommand();
        }
    },
    SHOW_ALL_TRAINS {
        {
            this.command = new ShowAllTrainsCommand();
        }
    },
    FIND_TRAINS_BY_STATIONS {
        {
            this.command = new FindTrainsByStationsCommand();
        }
    },
    TO_MAIN_PAGE {
        {
            this.command = new ToMainPageCommand();
        }
    },
    TO_REGISTRATION_PAGE {
        {
            this.command = new ToRegistrationPageCommand();
        }
    },
    TO_MY_TICKETS_PAGE {
        {
            this.command = new ToMyTicketsPageCommand();
        }
    },
    TO_PROFILE_PAGE {
        {
            this.command = new ToProfilePageCommand();
        }
    },
    TO_LOGIN_PAGE {
        {
            this.command = new ToLoginPageCommand();
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
