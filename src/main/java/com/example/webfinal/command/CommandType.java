package com.example.webfinal.command;

import com.example.webfinal.command.impl.LoginCommand;
import com.example.webfinal.command.impl.LogoutCommand;
import com.example.webfinal.command.impl.ShowPersonsCommand;
import com.example.webfinal.service.impl.UserServiceImpl;

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
    SHOW_PERSONS {
        {
            this.command = new ShowPersonsCommand();
        }
    } ;

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
