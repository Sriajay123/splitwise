package com.project.splitwise.commands;

import com.project.splitwise.exceptions.InvalidCommandException;

public interface Command {

    void execute(String input) throws InvalidCommandException;
}
