package com.project.splitwise.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private Map<String,Command> map;


    private CommandRegistry() {
        this.map = new HashMap<>();
    }

    private static final CommandRegistry INSTANCE=new CommandRegistry();


    public static CommandRegistry getInstance(){
        return INSTANCE;
    }


    public void addCommand(String key,Command command){
        map.put(key,command);
    }

    public Command getCommand(String input){
        for (Map.Entry<String, Command> entry : map.entrySet()) {
            String key = entry.getKey();
            if(input.contains(key)){
                return entry.getValue();
            }

        }
        throw new UnsupportedOperationException("please relook at the syntax");
    }



}
