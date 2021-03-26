package com.nyha.webfinal.command;

import com.nyha.webfinal.command.impl.LoginCommand;
import com.nyha.webfinal.command.impl.LogoutCommand;
import com.nyha.webfinal.command.impl.ShowUsersCommand;
import com.nyha.webfinal.service.impl.UserServiceImpl;

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
