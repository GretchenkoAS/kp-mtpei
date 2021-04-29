package com.nyha.webfinal.controller.command;

import com.nyha.webfinal.controller.command.impl.*;
import com.nyha.webfinal.model.service.impl.UserServiceImpl;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand(new UserServiceImpl());
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand(new UserServiceImpl());
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SHOW_USERS {
        {
            this.command = new ShowUsersCommand(new UserServiceImpl());
        }
    },
    CHANGE_LOCALE {
        {
            this.command = new ChangeLocaleCommand();
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
