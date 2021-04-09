package com.nyha.webfinal.controller.command;

import com.nyha.webfinal.controller.command.impl.*;
import com.nyha.webfinal.model.service.impl.UserServiceImpl;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand(new UserServiceImpl());
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    ADD_USER {
        {
            this.command = new AddUserCommand(new UserServiceImpl());
        }
    },
    CHANGE_LOCALE {
        {
            this.command = new ChangeLocaleCommand();
        }
    },
    SHOW_USERS {
        {
            this.command = new ShowUsersCommand(new UserServiceImpl());
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
